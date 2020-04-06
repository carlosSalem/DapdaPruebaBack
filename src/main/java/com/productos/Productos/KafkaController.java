package com.productos.Productos;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/pedidos")
public class KafkaController {



public KafkaTemplate<String, Producto> kafkaTemplate;

@Autowired
public KafkaController(KafkaTemplate<String, Producto> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
  
    } 

 
    
@PostMapping
public void post(Producto p){ //aqui iba un RequestBody antes de pedido
   
    
    System.out.println(p);
    
    System.out.print("mandando respuesta" + " ");
    kafkaTemplate.send("myTopic2", p);
    }


    
//listener recibe myTopic
   @KafkaListener(topics = "myTopic") 
   public void getFromKafka(Producto p){
   
       System.out.println(" Hemos recibido el pedido: " + p);
   }   
    

}
