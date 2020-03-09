package com.pedidos.Pedidos;

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
@RequestMapping({"/pedidos"})
public class Controlador {
    @Autowired
    PedidoService service;
    
    @GetMapping
    public List<Pedido>listar(){
        return service.listar();
        
    }

    /**
     *
     * @param p
     * @return
     */
    @PostMapping
    public Pedido agregar(@RequestBody Pedido p){
        return service.add(p);
    }
    @GetMapping(path = {"/{id}"})
    public Pedido listarId(@PathVariable("id")int id){
        return service.listarId(id);
    }
    @PutMapping(path = {"/{id}"})
    public Pedido editar(@RequestBody Pedido p,@PathVariable("id") int id){
      p.setId(id);
        return service.edit(p);
    }
    @DeleteMapping(path = {"/{id}"})
    public Pedido delete(@PathVariable("id") int  id){
        return service.delete(id);
    }
    
    
    
}
