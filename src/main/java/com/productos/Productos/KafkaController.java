package com.productos.Productos;


import com.productos.Productos.Pedido;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
   
    
    System.out.println(r);
    
    System.out.print("mandando respuesta" + r);
    kafkaTemplate.send("myTopic", r);
    }


    
//@GetMapping(path = {"/{id}"})
//    public Producto listarId(@PathVariable("id")int id){
//        return service.listarId(id);
//    }    
   
@KafkaListener(topics = "myTopic")
@KafkaHandler
     public void getFromKafka(String[] pe){
         
       System.out.println("El pedido sin hash:" + pe);
       String cantidadPedido = pe[2].toString();
       System.out.println("La candidad del pedido es:" + cantidadPedido);
       int finC=pe[2].length();
       String cantidadPe = pe[2].substring(12, finC-2);
       System.out.println("La candidad sin comillas es:" + cantidadPe);


       
       int fin=pe[1].length();
       String nombrePe = pe[1].substring(10, fin-1);
       System.out.println ("buscando producto con el nombre: " + nombrePe);
       String producto = service.listarNombre(nombrePe).toString();
       System.out.println("producto encontrado: " + producto);
       String cantidadPr = producto.replaceAll("[^0-9]", "");
       System.out.println("Digitos extraidos del producto: " + cantidadPr);
       System.out.println("Pasando datos a integers ");
       
       
       int ro = Integer.parseInt(cantidadPr.trim());
       int p = Integer.parseInt(cantidadPe.trim());
       
       System.out.println("cantidad en integer de Pedido: " + p);
       System.out.println("cantidad en integer de Producto: " + ro);
       
       
       String r = "";
       if (  p < ro ) {
           r = "si";
       } else {
           r = "no";
       }
       
       System.out.println("puedes hacer el pedido?: " + r);
       post(r);
       
      //hacer un comparador, meter la respuest en r
      //y llamar al metodo post de arriba
       
       
       
   }
     

 
    

}
