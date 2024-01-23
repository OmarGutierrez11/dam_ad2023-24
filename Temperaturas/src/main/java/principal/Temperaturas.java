package principal;

import java.sql.*;

public class Temperaturas {

    private static final String cadenaConexion = "jdbc:mysql://localhost/Temperaturas?user=root&password=root";
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

    //METODO QUE IDENTIFICA EL SENSOR EL CUAL HA REGISTRADO LA MAXIMA TEMPERATURA:
    private static int encontrarSensorTempMax() {
        int maxTemperatureSensorID = -1;
        double maxTemperature = Double.MIN_VALUE;


            String sql = "SELECT d.sensorID, MAX(d.temperature) AS maxTemperature " +
                    "FROM Temperaturas.Data d " +
                    "GROUP BY d.sensorID " +
                    "ORDER BY maxTemperature DESC LIMIT 1";

            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    maxTemperatureSensorID = resultSet.getInt("sensorID");
                    maxTemperature = resultSet.getDouble("maxTemperature");
                    System.out.println("Maximum Temperature: " + maxTemperature);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }



        return maxTemperatureSensorID;
    }

    //METODO QUE ELIMINA TODOS LOS SENSORES SITUADOS EN UN MISMO PAIS
    private static int eliminarSensorPorPais(String pais) {
        int contadorEliminados = 0;


            String sql = "DELETE FROM Temperaturas.Sensor " +
                    "WHERE ownerID IN (SELECT ownerID FROM Temperaturas.Owner WHERE country = ?)";

            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setString(1, pais);
                contadorEliminados = statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        return contadorEliminados;
    }

    //METODO QUE IDENTIFICA CUAL ES LA REGION CON MAYOR NUMERO DE SENSORES EN ELLA:
    private static String regionConMasSensores() {
        String region = null;
        int contSensores = 0;


            String sql = "SELECT s.serverRegionName, COUNT(*) AS sensorCount " +
                    "FROM Temperaturas.Sensor s " +
                    "GROUP BY s.serverRegionName " +
                    "ORDER BY sensorCount DESC LIMIT 1";

            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    region = resultSet.getString("serverRegionName");
                    contSensores = resultSet.getInt("sensorCount");
                    System.out.println("Numero de sensores en la region: " + contSensores);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        return region;
    }

    //METODO PARA OBTENER LA TEMPERUTARA MEDIA SEGUN CADA MODELO DE SENSOR:
    private static void tempMediaModeloSen() {

            String sql = "SELECT sm.modelCode, sm.modelName, " +
                    "AVG(d.temperature) AS averageTemperature " +
                    "FROM Temperaturas.SensorModel sm " +
                    "LEFT JOIN Temperaturas.Sensor s ON sm.modelCode = s.SensorModel_modelCode " +
                    "LEFT JOIN Temperaturas.Data d ON s.sensorID = d.sensorID " +
                    "GROUP BY sm.modelCode, sm.modelName";

            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int modelCode = resultSet.getInt("modelCode");
                    String modelName = resultSet.getString("modelName");
                    double averageTemperature = resultSet.getDouble("averageTemperature");

                    System.out.println("Model Code: " + modelCode +
                            ", Model Name: " + modelName +
                            ", Average Temperature: " + averageTemperature);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }


    //METODO QUE ENCUENTRA LOS PROPIETARIOS LOS CUALES HAN REGISTRADO MAS DATOS CON SUS SENSORES
    private static void propietariosMasDatosRegistrados() {

            String sql = "SELECT o.ownerID, o.name, COUNT(d.dataID) AS dataCount " +
                    "FROM Temperaturas.Owner o " +
                    "LEFT JOIN Temperaturas.Sensor s ON o.ownerID = s.ownerID " +
                    "LEFT JOIN Temperaturas.Data d ON s.sensorID = d.sensorID " +
                    "GROUP BY o.ownerID, o.name " +
                    "ORDER BY dataCount DESC " +
                    "LIMIT 3";

            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int ownerID = resultSet.getInt("ownerID");
                    String ownerName = resultSet.getString("name");
                    int dataCount = resultSet.getInt("dataCount");

                    System.out.println("Owner ID: " + ownerID +
                            ", Owner Name: " + ownerName +
                            ", Data Count: " + dataCount);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        //METODO QUE LISTA POR MODELO LOS SENSORES QUE HAN REGISTRADO TEMPERATURAS POR DEBAJO DEL RANGO MIN
    private static void listarModelosRegistroInferiorMin() {

            String sql = "SELECT sm.modelCode, sm.modelName, COUNT(d.dataID) AS belowMinRangeCount " +
                    "FROM Temperaturas.SensorModel sm " +
                    "LEFT JOIN Temperaturas.Sensor s ON sm.modelCode = s.SensorModel_modelCode " +
                    "LEFT JOIN Temperaturas.Data d ON s.sensorID = d.sensorID " +
                    "WHERE d.temperature < sm.minTemperatureRange " +
                    "GROUP BY sm.modelCode, sm.modelName";

            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int modelCode = resultSet.getInt("modelCode");
                    String modelName = resultSet.getString("modelName");
                    int belowMinRangeCount = resultSet.getInt("belowMinRangeCount");

                    System.out.println("Model Code: " + modelCode +
                            ", Model Name: " + modelName +
                            ", Below Min Range Count: " + belowMinRangeCount);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    //METODO PARA ANADIR NUEVOS SENSORES
    private static void anadirNuevoModelo(SensorModel sensorModel) {

            String sql = "INSERT INTO Temperaturas.SensorModel " +
                    "(modelCode, modelName, minTemperatureRange, maxTemperatureRange, manufacturer) " +
                    "VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setInt(1, sensorModel.getModelCode());
                statement.setString(2, sensorModel.getModelName());
                statement.setDouble(3, sensorModel.getMinTemperatureRange());
                statement.setDouble(4, sensorModel.getMaxTemperatureRange());
                statement.setString(5, sensorModel.getManufacturer());

                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }


    //METODO QUE ELIMINA LOS REGISTROS DE TEMPS FUERA DE LOS RANGOS OPERATIVOS
    private static void eliminarRegistrosFueraDeRango() {

            String sql = "DELETE FROM Temperaturas.Data " +
                    "WHERE temperature < " +
                    "(SELECT sm.minTemperatureRange FROM Temperaturas.SensorModel sm " +
                    "JOIN Temperaturas.Sensor s ON sm.modelCode = s.SensorModel_modelCode " +
                    "WHERE s.sensorID = Data.sensorID) OR " +
                    "temperature > " +
                    "(SELECT sm.maxTemperatureRange FROM Temperaturas.SensorModel sm " +
                    "JOIN Temperaturas.Sensor s ON sm.modelCode = s.SensorModel_modelCode " +
                    "WHERE s.sensorID = Data.sensorID)";

            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.executeUpdate();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }

    }



    //MAIN:
    public static void main (String[]args){
        //UTILIZACION METODO ENCONTRAR EL SENSOR QUE REGISTRO LA MAYOR TEMPERATURA
        int IDmaxTemp = encontrarSensorTempMax();
        System.out.println("Sensor ID que registro la maxima temperatura: " + IDmaxTemp);
        //UTILIACION METODO ELIMINAR TODOS LOS SENSORES DE UN MISMO PAIS DETERMINADO
        String pais = "USA";
        int contEliminados = eliminarSensorPorPais(pais);
        System.out.println(contEliminados + " sensores eliminados en: " + pais);
        //UTILIZACION METODO BUSCAR LA REGION QUE TIENE MAS SENSORES
        String region = regionConMasSensores();
        System.out.println("Region with the most sensors: " + region);
        //UTILIZACION METODO CALCULAR TEMPERATURA MEDIA SEGUN EL MODELO DE SENSOR
        tempMediaModeloSen();
        //UTILIZACION METODO ENCONTRAR PROPIETARIOS CON MAS DATOS ALMACENADOS ATRAVES DE SUS SENSORES
        propietariosMasDatosRegistrados();
        //UTILIZACION METODO QUE LISTA POR MODELO LOS SENSORES QUE HAN REGISTRADO TEMPERATURAS POR DEBAJO DEL RANGO MIN
        listarModelosRegistroInferiorMin();
        //UTILIZACION DEL METODO PARA ANADIR NUEVOS MODELOS DE SENSORES
        SensorModel nuevoSensorModel = new SensorModel(4, "Model D", -15.0, 55.0, "Manufacturer W");
        anadirNuevoModelo(nuevoSensorModel);
        System.out.println("Se ha anadido un nuevo modelo de sensor");
        //UTILIZACION METODO QUE ELIMINA LOS REGISTROS DE TEMPS FUERA DE LOS RANGOS OPERATIVOS:
        eliminarRegistrosFueraDeRango();
    }



}
