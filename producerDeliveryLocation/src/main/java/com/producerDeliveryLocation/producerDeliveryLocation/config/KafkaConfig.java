package com.producerDeliveryLocation.producerDeliveryLocation.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    public NewTopic topic(){
        return TopicBuilder
                .name("location-update-topic")

//     --> we can pass no for partiton and replicas if not it will take deafult value
//                .partitions()
//                .replicas()
                .build() ;
    }

}
