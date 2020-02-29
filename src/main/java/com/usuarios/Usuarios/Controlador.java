package com.usuarios.Usuarios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping({"/usuarios"})
public class Controlador {
    @Autowired
    UsuarioService service;
    
    @GetMapping
    public List<Usuario>listar(){
        return service.listar();
        
    }
    @PostMapping
    public Usuario agregar(@RequestBody Usuario p){
        return service.add(p);
    }
    @GetMapping(path = {"/{id}"})
    public Usuario listarId(@PathVariable("id")int id){
        return service.listarId(id);
    }
    
    
    
}
