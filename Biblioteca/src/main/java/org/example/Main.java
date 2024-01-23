package org.example;


import java.sql.*;


public class Main {
    private static final String cadenaConexion = "jdbc:mysql://localhost/biblioteca?user=root&password=root";
    private static  final Connection con;

    static {
        try {
            con = DriverManager.getConnection(cadenaConexion);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static final Statement stmt;

    static {
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //DECLARACION DE LOS METODOS:
    public ResultSet obtenerTodosLosLibros() {
        ResultSet resultSet = null;

        try {
            resultSet = stmt.executeQuery("SELECT * from libros");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }


    public void insertarLibro(String titulo, String autor, String isbn, String editorial, int anioPublicacion, int copias) {
        try {

            String sql = "INSERT INTO libros (titulo, autor, isbn, editorial, anio_publicacion, copias) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, autor);
            preparedStatement.setString(3, isbn);
            preparedStatement.setString(4, editorial);
            preparedStatement.setInt(5, anioPublicacion);
            preparedStatement.setInt(6, copias);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Libro insertado correctamente.");
            } else {
                System.out.println("No se pudo insertar el libro.");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarLibroPorId(int idLibro) {
        try {
            String sql = "DELETE FROM libros WHERE id_libro = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, idLibro);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Libro eliminado correctamente.");
            } else {
                System.out.println("No se encontró el libro con ID: " + idLibro);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarLibroPorTitulo(String titulo) {
        try {
            String sql = "DELETE FROM libros WHERE titulo = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, titulo);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Libro eliminado correctamente.");
            } else {
                System.out.println("No se encontró el libro con título: " + titulo);
            }


            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet obtenerLibrosPorAutor(String autor) {
        ResultSet resultSet = null;
        try {

            String sql = "SELECT * FROM libros WHERE autor = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, autor);

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public ResultSet obtenerSociosConPrestamos(boolean ordenarPorTitulo) {
        ResultSet resultSet = null;

        try {

            String sql = "SELECT u.nombre AS nombre_socio, l.titulo " +
                    "FROM usuarios u " +
                    "JOIN prestamos p ON s.id_socio = p.id_socio " +
                    "JOIN libros l ON p.id_libro = l.id_libro " +
                    (ordenarPorTitulo ? "ORDER BY l.titulo" : "");

            PreparedStatement preparedStatement = con.prepareStatement(sql);


            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public ResultSet obtenerSociosPorLibro(String criterio, boolean buscarPorTitulo) {
        ResultSet resultSet = null;

        try {
            String sql = "SELECT u.nombre AS nombre_socio " +
                    "FROM usuarios u " +
                    "JOIN prestamos p ON s.id_socio = p.id_socio " +
                    "JOIN libros l ON p.id_libro = l.id_libro " +
                    "WHERE " + (buscarPorTitulo ? "l.titulo" : "l.isbn") + " = ?";


            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, criterio);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public void actualizarLibro(int idLibro, String nuevaEditorial, int nuevoAnioPublicacion, int nuevasCopias) {
        try {
            String sql = "UPDATE libros SET editorial = ?, anio_publicacion = ?, copias = ? WHERE id_libro = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, nuevaEditorial);
            preparedStatement.setInt(2, nuevoAnioPublicacion);
            preparedStatement.setInt(3, nuevasCopias);
            preparedStatement.setInt(4, idLibro);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Información del libro actualizada correctamente.");
            } else {
                System.out.println("No se encontró el libro con ID: " + idLibro);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet obtenerHistorialPrestamosUsuario(int idUsuario) {
        ResultSet resultSet = null;

        try {

            String sql = "SELECT l.titulo, p.fecha_prestamo, p.fecha_devolucion, p.devuelto " +
                    "FROM prestamos p " +
                    "JOIN libros l ON p.id_libro = l.id_libro " +
                    "WHERE p.id_socio = ? " +
                    "ORDER BY p.fecha_prestamo DESC";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, idUsuario);


            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public int contarLibrosPrestados() {
        int totalLibrosPrestados = 0;

        try {
            String sql = "SELECT COUNT(*) AS total FROM prestamos WHERE devuelto = false";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                totalLibrosPrestados = resultSet.getInt("total");
                System.out.println("Número total de libros prestados: " + totalLibrosPrestados);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalLibrosPrestados;
    }

    public ResultSet buscarLibroPorISBN(String isbn) {
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM libros WHERE isbn = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, isbn);

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public static void listarPrestamosVencidosNoDevueltos() throws SQLException {
        ResultSet resultSet = null;

        String sql = "SELECT p.id_prestamo, u.nombre AS nombre_usuario, u.apellido AS apellido_usuario, p.fecha_prestamo, p.fecha_devolucion "
                + "FROM prestamos p "
                + "JOIN usuarios u ON p.id_usuario = u.id_usuario "
                + "WHERE p.fecha_devolucion < CURDATE() AND p.fecha_devolucion IS NOT NULL";

        PreparedStatement preparedStatement = con.prepareStatement(sql);


        resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idPrestamo = resultSet.getInt("id_prestamo");
                String nombreUsuario = resultSet.getString("nombre_usuario");
                String fechaPrestamo = resultSet.getString("fecha_prestamo");
                String fechaDevolucion = resultSet.getString("fecha_devolucion");

                System.out.println("ID Préstamo: " + idPrestamo);
                System.out.println("Usuario: " + nombreUsuario );
                System.out.println("Fecha de Préstamo: " + fechaPrestamo);
                System.out.println("Fecha de Devolución: " + fechaDevolucion);
                System.out.println("---------------------------");
            }


    }

    public static void librosMasPopulares() throws SQLException {
        ResultSet resultSet = null;
        String sql = "SELECT l.id_libro, l.titulo, COUNT(p.id_prestamo) AS total_prestamos "
                + "FROM libros l "
                + "LEFT JOIN prestamos p ON l.id_libro = p.id_libro "
                + "GROUP BY l.id_libro, l.titulo "
                + "ORDER BY total_prestamos DESC";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idLibro = resultSet.getInt("id_libro");
                String tituloLibro = resultSet.getString("titulo");
                int totalPrestamos = resultSet.getInt("total_prestamos");

                System.out.println("ID Libro: " + idLibro);
                System.out.println("Título: " + tituloLibro);
                System.out.println("Total de Préstamos: " + totalPrestamos);

            }
    }


















    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Main biblioteca = new Main();
        ResultSet rs = biblioteca.obtenerTodosLosLibros();

        try {
            while (rs.next()) {
                int idLibro = rs.getInt("id_libro");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");

                System.out.println("ID: " + idLibro + ", Título: " + titulo + ", Autor: " + autor);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



        //UTILIZACION METODO INSERTAR NUEVOS LIBROS:
        biblioteca.insertarLibro("Jeronimo Stilton", "Omar", "11", "Editorial RatatuiSM", 2023, 12);
        biblioteca.insertarLibro("La vida y la filosofia", "Iyan Garcia", "22", "Editorial Savia", 2021, 46);
        biblioteca.insertarLibro("Sambinha", "ViniJR", "7", "Editorial JR", 2023, 8);
        biblioteca.insertarLibro("El nano", "Fernando Alonso", "33", "Editorial Alonso", 2018, 88);

        //UTILIZACION DEL METODO ELIMINAR POR ID DE LIBRO
        biblioteca.eliminarLibroPorId(1);
        //UTILIZACION DEL METODO ELIMINAR POR TITULO DE LIBRO
        biblioteca.eliminarLibroPorTitulo("Sambinha");

        //OBTENER LIBROS DE UN AUTOR:
        ResultSet resultSet = biblioteca.obtenerLibrosPorAutor("Iyan Garcia");

        try {
            while (resultSet.next()) {
                int idLibro = resultSet.getInt("id_libro");
                String titulo = resultSet.getString("titulo");
                String autorResultado = resultSet.getString("autor");

                System.out.println("ID: " + idLibro + ", Título: " + titulo + ", Autor: " + autorResultado);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //OBTENER LOS SOCIOS QUE TIENEN LIBROS PRESTADOS
         resultSet = biblioteca.obtenerSociosConPrestamos(true);


        try {

            while (resultSet.next()) {
                String nombreSocio = resultSet.getString("nombre_socio");
                String tituloLibro = resultSet.getString("titulo");

                System.out.println("Socio: " + nombreSocio + ", Título del Libro: " + tituloLibro);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Socios con Libro Específico:
        ResultSet resultSetPorTitulo = biblioteca.obtenerSociosPorLibro("El nano", true);
        ResultSet resultSetPorISBN = biblioteca.obtenerSociosPorLibro("11", false);

        try {

            System.out.println("Socios con el libro por Título:");
            while (resultSetPorTitulo.next()) {
                String nombreSocio = resultSetPorTitulo.getString("nombre_socio");
                System.out.println("Socio: " + nombreSocio);
            }

            System.out.println("Socios con el libro por ISBN:");
            while (resultSetPorISBN.next()) {
                String nombreSocio = resultSetPorISBN.getString("nombre_socio");
                System.out.println("Socio: " + nombreSocio);
            }

            resultSetPorTitulo.close();
            resultSetPorISBN.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Actualizar Datos de un Libro:
        biblioteca.actualizarLibro(1, "OmarEditorialPro", 2046, 234);

        //Historial de Préstamos de un Usuario:
        resultSet = biblioteca.obtenerHistorialPrestamosUsuario(1);

        try {
            while (resultSet.next()) {
                String tituloLibro = resultSet.getString("titulo");
                String fechaPrestamo = resultSet.getString("fecha_prestamo");
                String fechaDevolucion = resultSet.getString("fecha_devolucion");
                boolean devuelto = resultSet.getBoolean("devuelto");

                System.out.println("Libro: " + tituloLibro +
                        ", Fecha de Préstamo: " + fechaPrestamo +
                        ", Fecha de Devolución: " + (devuelto ? fechaDevolucion : "No devuelto"));
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Contar Libros Prestados:
        biblioteca.contarLibrosPrestados();

        //Buscar Libro por ISBN:
        resultSet = biblioteca.buscarLibroPorISBN("33");

        try {
            if (resultSet.next()) {
                int idLibro = resultSet.getInt("id_libro");
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");

                System.out.println("ID: " + idLibro + ", Título: " + titulo + ", Autor: " + autor);
            } else {
                System.out.println("No se encontró un libro con el ISBN proporcionado.");
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Préstamos Vencidos:
        try {
            listarPrestamosVencidosNoDevueltos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //Libros mas populares:
        try {
            librosMasPopulares();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}