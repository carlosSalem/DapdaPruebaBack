package com.usuarios.Usuarios;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column(length=60)
    private String pass;
    
    private Boolean enabled;
    
    @ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
    private List<Role> roles;
    
    
    /****/
    private static final long serialVersion = 1L;

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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
