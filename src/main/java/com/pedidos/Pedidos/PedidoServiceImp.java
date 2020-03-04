package com.pedidos.Pedidos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PedidoServiceImp implements PedidoService {
    @Autowired
    private PedidoRepositorio repositorio;
    @Override
    public List<Pedido> listar() {
        return repositorio.findAll();
    }

    @Override
    public Pedido listarId(int id) {
        return repositorio.findById(id);
    }

    @Override
    public Pedido add(Pedido p) {
        return repositorio.save(p);
    }

    @Override
    public Pedido edit(Pedido p) {
        return repositorio.save(p);
    }

    @Override
    public Pedido delete(int id) {
        Pedido p=repositorio.findById(id);
        if(p!=null){
            repositorio.delete(p);
        }
        return p;    }
    
    

    
    
    
}
