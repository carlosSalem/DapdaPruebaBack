package com.productos.Productos;

import java.util.List;
//2*
//en el service damos los metodos

public interface ProductoService {
    List<Producto>listar();
    Producto listarId(int id);
    Producto add(Producto p);
    Producto edit(Producto p);
    Producto delete(int p);
    
    
    //aki va
    List<Producto> listarNombre(String nombre);
    //añadir la funcion de coger cantidad para compararla con el pedido
//    Producto search(String cantidad);
    //fin

    
    
}
