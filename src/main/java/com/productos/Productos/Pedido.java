package com.productos.Productos;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String cantidad;
    
    
    
    //funcion que cambia el return del front para no coger @mierdas
    @Override
    public String toString(){ 
        return nombre + " " + cantidad;
        
    }  
   
    //fin de la funcion
    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    
    
}
