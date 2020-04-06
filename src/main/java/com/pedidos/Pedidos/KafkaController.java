package com.pedidos.Pedidos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;



public class KafkaController {



public KafkaTemplate<String, Pedido> kafkaTemplate;

@Autowired
public KafkaController(KafkaTemplate<String, Pedido> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
  
    } 

  

   

    
@PostMapping
public void post(Pedido p){ //aqui iba un RequestBody antes de pedido
   
    
    System.out.println(p);
    
    System.out.print("posteando en kafka" + " ");
    kafkaTemplate.send("myTopic", p);
    }





}
