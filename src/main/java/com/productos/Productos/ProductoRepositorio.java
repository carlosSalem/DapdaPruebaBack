package com.productos.Productos;


import java.util.List;
import org.springframework.data.repository.Repository;
//1*
//<objeto, tipo dato>
public interface ProductoRepositorio extends Repository<Producto, Integer> {
  
    List<Producto>findAll();
    Producto findById(int id);
    Producto save (Producto p);
    void delete(Producto p);
    
    //Coger el nombre de la BBDD
    //obj findByX(tipo campo)
    List<Producto> findByNombreIgnoreCase(String nombre);//cambiar a findByNombreDeLaTabla
//    Producto findByNombre(String cantidad);
    //fin
    
}
//public Misconones(cosa que devuele){ //aki se pone lo que devuelve
//
//nombrefuncion(elobjetoqueselepasa);
//
//
//}
