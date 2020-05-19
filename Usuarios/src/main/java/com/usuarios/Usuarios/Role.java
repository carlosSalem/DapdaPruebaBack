package com.usuarios.Usuarios;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique=true, length=20)
    private String nombre;
    @Column
    private String pass;
    
     /****/
    private static final long serialVersion = 1L;

    public long getId() {
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}