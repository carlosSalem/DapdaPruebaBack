package com.pedidos.Pedidos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pedidos.Pedidos.Pedido;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.kafka.core.KafkaTemplate;




@Service
public class PedidoServiceImp implements PedidoService  {
    
    
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
    

    @Autowired
    private KafkaConfig kafkaConfig;
    
    
    @Override
    @PostMapping
    public Pedido add(Pedido p) {
       
      KafkaTemplate kafkaTemplate = kafkaConfig.kafkaTemplate();
      
      KafkaController mandar = new KafkaController(kafkaTemplate);
      
      //mandando pedido con kafka
      mandar.post(p);
        
      //el guardado en la BBDD lo deberia de meter en un if()  
      System.out.println("Guardando en DDBB" + " " + p);
        
      //guardando pedido 
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
