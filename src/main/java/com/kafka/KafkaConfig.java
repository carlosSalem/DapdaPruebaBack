/*
 * Kafka productor para el objeto pedidos, mandara un
 *topic y un json a Productos.
 */
package com.kafka;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.pedidos.Pedidos.Pedido;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 *
 * @author Carlos
 */
@Configuration
public class KafkaConfig {
    
    @Bean
    ProducerFactory<String, Pedido> producerFactory(){
        Map<String, Object> config = new HashMap<>();
        
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        
        return new DefaultKafkaProducerFactory<>(config);  
    
    }
    @Bean
    public KafkaTemplate<String, Pedido> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
