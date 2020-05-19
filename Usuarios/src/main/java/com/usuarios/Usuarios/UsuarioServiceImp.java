package com.usuarios.Usuarios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;



@Service
public class UsuarioServiceImp implements UsuarioService {
    @Autowired
    private UsuarioRepositorio repositorio;
    @Override
    public List<Usuario> listar() {
        return repositorio.findAll();
    }
    //List<GrantedAuthority> authorities = usuario.getRoles();

    @Override
    public Usuario listarId(int id) {
        return repositorio.findById(id);
    }
    
    

    @Override
    public Usuario add(Usuario p) {
        return repositorio.save(p);
    }

    @Override
    public Usuario edit(Usuario p) {
        return repositorio.save(p);
    }


    @Override
    public Usuario delete(int id) {
        Usuario p=repositorio.findById(id);
        if(p!=null){
            repositorio.delete(p);
        }
        return p;

    }

     
    
}
