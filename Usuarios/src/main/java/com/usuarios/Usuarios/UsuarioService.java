package com.usuarios.Usuarios;

import java.util.List;



public interface UsuarioService {
    List<Usuario>listar();
    Usuario listarId(int id);
    Usuario add(Usuario p);
    Usuario edit(Usuario p);
    Usuario delete(int p);
    
}
