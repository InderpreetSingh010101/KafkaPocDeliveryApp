package com.producerDeliveryLocation.producerDeliveryLocation.service;


import com.producerDeliveryLocation.producerDeliveryLocation.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService{

    @Autowired
    private KafkaTemplate<String , String> kafkaTemplate ;

    private Logger logger = LoggerFactory.getLogger(KafkaServiceImpl.class);

    @Override
     public Boolean updateLocation(String locationCoordinates){

        kafkaTemplate.send(AppConstants.LOCATION_UPDATE_TOPIC , locationCoordinates) ;
        logger.info("Data Produced");
        return true ;
     }
}
