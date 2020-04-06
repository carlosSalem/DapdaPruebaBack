package com.productos.Productos;

import java.util.List;



public interface ProductoService {
    List<Producto>listar();
    Producto listarId(int id);
    Producto add(Producto p);
    Producto edit(Producto p);
    Producto delete(int p);
    
    //aki va
    //Producto listarNombre(String nombre);
    //añadir la funcion de coger cantidad para compararla con el pedido
    
    //fin
    
}
