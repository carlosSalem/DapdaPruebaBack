package com.kafka;

import com.pedidos.Pedidos.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class KafkaController {

private KafkaTemplate<String, Pedido> kafkaTemplate;

@Autowired
public KafkaController(KafkaTemplate<String, Pedido> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
  
    } 
@PostMapping
public void post(@RequestBody Pedido pedido){
        kafkaTemplate.send("myTopic", pedido);
    }

}
