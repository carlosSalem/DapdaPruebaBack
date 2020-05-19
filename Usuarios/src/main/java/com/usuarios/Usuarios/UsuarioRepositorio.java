package com.usuarios.Usuarios;


import java.util.List;
import org.springframework.data.repository.Repository;

public interface UsuarioRepositorio extends Repository<Usuario, Integer> {
  
    List<Usuario>findAll(); 
    Usuario save (Usuario p);
    void delete(Usuario p);
    Usuario findById(int id);


    
}
