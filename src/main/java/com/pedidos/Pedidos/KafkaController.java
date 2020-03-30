package com.pedidos.Pedidos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = {"http://localhost:4200"})
//@Controller
//@RequestMapping(value = "/pedidos", method = RequestMethod.GET)//el problema esta en la ruta
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
