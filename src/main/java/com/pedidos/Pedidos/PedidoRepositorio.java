package com.pedidos.Pedidos;


import java.util.List;
import org.springframework.data.repository.Repository;

public interface PedidoRepositorio extends Repository<Pedido, Integer> {
  
    List<Pedido>findAll();
    Pedido findById(int id);
    Pedido save (Pedido p);
    void delete(Pedido p);
    
}
