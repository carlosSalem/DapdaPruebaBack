package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidos.Pedidos.Pedido;

@RestController
public class ControladorKafka {
    
    @Autowired
    private KafkaTemplate<Object, Object> template;
    
    @PostMapping(path = "/send/pedido/{what}")
	public void sendFoo(@PathVariable String what) {
		this.template.send("topic1", new Pedido(what));
	}
    
    
}
