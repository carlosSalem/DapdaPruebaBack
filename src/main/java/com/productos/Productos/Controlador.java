package com.productos.Productos;



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


//cambios
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping({"/productos"})
public class Controlador {
    @Autowired
    ProductoService service;
    
    @GetMapping
    public List<Producto>listar(){
        return service.listar();
        
    }
    @PostMapping
    public Producto agregar(@RequestBody Producto p){
        return service.add(p);
    }
    @GetMapping(path = {"/{id}"})
    public Producto listarId(@PathVariable("id")int id){
        return service.listarId(id);
    }
    @PutMapping(path = {"/{id}"})
    public Producto editar(@RequestBody Producto p,@PathVariable("id") int id){
      p.setId(id);
        return service.edit(p);
    }
    @DeleteMapping(path = {"/{id}"})
    public Producto delete(@PathVariable("id") int  id){
        return service.delete(id);
    }
    
    
    
}
