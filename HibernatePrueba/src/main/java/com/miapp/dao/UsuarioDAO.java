package com.miapp.dao;

import com.miapp.modelo.Usuario;

import java.util.List;

public interface UsuarioDAO {
    void addUsuario (Usuario usuario);
    Usuario getusuarioByID( Long id);
    List<Usuario> getAllUsuarios();
    void updateUsuario (Usuario usuario);
    void deleteUsuario (Usuario usuario);


}
