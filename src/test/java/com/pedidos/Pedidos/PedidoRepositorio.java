package com.pedidos.Pedidos;


import java.util.List;
import org.springframework.data.repository.Repository;

public interface PedidoRepositorio extends Repository<Pedido, Integer> {
  
    List<Pedido>findAll(); 
//  Usuario findOne(int id); findOne no funciona en las nuevas versiones de Spring. He perdido mucho tiempo con esto.
    Pedido save (Pedido p);
    void delete(Pedido p);

    Pedido findById(int id);


    
}