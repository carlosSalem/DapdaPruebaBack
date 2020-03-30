package com.pedidos.Pedidos;

import com.pedidos.Pedidos.SimpleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka", method = RequestMethod.GET)//el problema esta en la ruta
public class KafkaController {

// kafka controller extiende a pedidoServiImp

public KafkaTemplate<String, SimpleModel> kafkaTemplate;

@Autowired
public KafkaController(KafkaTemplate<String, SimpleModel> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
  
    } 

    
@PostMapping
public void post(@RequestBody SimpleModel simpleModel){
   
    
    System.out.println(simpleModel);
    
    System.out.print("posteando en kafka");
    kafkaTemplate.send("myTopic", simpleModel);
    }





}
