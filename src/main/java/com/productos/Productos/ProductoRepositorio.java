package com.productos.Productos;


import java.util.List;
import org.springframework.data.repository.Repository;


public interface ProductoRepositorio extends Repository<Producto, Integer> {
  
    List<Producto>findAll();
    //Usuario findOne(int id);
    //Usuario save (Usuario p);
    //void delete(Usuario p);
    
}
