package com.usuarios.Usuarios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//cambios.
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
    @PutMapping(path = {"/{id}"})
    public Usuario editar(@RequestBody Usuario p,@PathVariable("id") int id){
      p.setId(id);
        return service.edit(p);
    }
    @DeleteMapping(path = {"/{id}"})
    public Usuario delete(@PathVariable("id") int  id){
        return service.delete(id);
    }
    
    
}
