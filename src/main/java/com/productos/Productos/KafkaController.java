package com.productos.Productos;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class KafkaController {



public KafkaTemplate<String, String> kafkaTemplate;

@Autowired
public KafkaController(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;//metodo objeto mandar string
        //System.out.println(" kafka listener activado ");
    } 

 
    
@PostMapping
public void post(String r){ //aqui iba un RequestBody antes de pedido
   
    // r sera la respuesta
    System.out.println(r);
    
    System.out.print("mandando respuesta" + " ");
    //kafkaTemplate.send("myTopic", p);
    }


    
    //aki peta
   @KafkaListener(topics = "myTopic")
   @KafkaHandler
   public void getFromKafka(String p){
       System.out.println("kafka listener activado:");
       System.out.println("Hemos recibido el pedido: " + p);
   }   
    

}
