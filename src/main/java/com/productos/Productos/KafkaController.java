package com.productos.Productos;



import java.util.Arrays;
import static org.aspectj.weaver.Iterators.array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class KafkaController {
//importamos la interfaz
@Autowired
    ProductoService service;

public KafkaTemplate<String, String> kafkaTemplate;

@Autowired
public KafkaController(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;//metodo objeto mandar string
        
    } 
//tengo que iyectar el servicio igual que en controlador  ProductoService service;
 
    
@PostMapping
public void post(String r){ //aqui iba un RequestBody antes de pedido
   
    // r sera la respuesta
    System.out.println(r);
    
    System.out.print("mandando respuesta" + " ");
    //kafkaTemplate.send("myTopic", p);
    }


    
//@GetMapping(path = {"/{id}"})
//    public Producto listarId(@PathVariable("id")int id){
//        return service.listarId(id);
//    }    
   
@KafkaListener(topics = "myTopic")
@KafkaHandler
     public void getFromKafka(String[] pe){
       System.out.println("kafka listener activado:" + pe);
       //System.out.println("Hemos recibido el pedido: " + Arrays.toString(pe));
       
        //String name = pe.
       
       //System.out.println("extrayendo del mensaje y dividiendolo en " + pe[1] + pe[2]);
       //pasando a String el nombre de arrayString
       //String nombrePe = pe[1];
       
       String nombrePe = pe.nombre;
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       System.out.println("producto encontrado " + nombrePe);
      // String nombrePe = "ford focus";
       
       
       
       Producto pr = service.listarNombre(nombrePe); //devuelve null si no lo encuentra.
       //pr.setNombre(nombrePe);
       //inicializando variable nombre
       //String nombre = null;
       //String cantidadPr=null;
       //llamar metodo que busque en la BBDD por nombre
       
       //service.listarNombre(nombrePe);
       
       //pr = service.listarNombre(nombrePe); // No se como hago para que devuelva la busqueda.
       

       //repositorio.findByNombre(nombre);
       System.out.println("producto encontrado " + pr);
       
       
       
       
       
       //comprobar en la BBDD si existe el producto
       
       
       //para comparar los datos de cantidad
       //Integer.parseInt(pe[1]) == Integer.parseInt("04")
       
   }
     

 
    

}
