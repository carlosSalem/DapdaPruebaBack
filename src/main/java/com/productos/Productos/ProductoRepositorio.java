package com.productos.Productos;


import java.util.List;
import org.springframework.data.repository.Repository;


public interface ProductoRepositorio extends Repository<Producto, Integer> {
  
    List<Producto>findAll();
    Producto findById(int id);
    Producto save (Producto p);
    void delete(Producto p);
    
}
