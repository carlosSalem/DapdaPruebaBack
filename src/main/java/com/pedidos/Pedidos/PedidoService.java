package com.pedidos.Pedidos;

import java.util.List;



public interface PedidoService {
    List<Pedido>listar();
    Pedido listarId(int id);
    Pedido add(Pedido p);
    Pedido edit(Pedido p);
    Pedido delete(int p);
    
}
