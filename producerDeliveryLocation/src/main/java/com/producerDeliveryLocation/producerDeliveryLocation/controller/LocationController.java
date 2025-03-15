package com.producerDeliveryLocation.producerDeliveryLocation.controller;


import com.producerDeliveryLocation.producerDeliveryLocation.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")

public class LocationController {

    @Autowired
    KafkaService kafkaService ;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(@RequestParam("coordinates") String coordinates){
        Boolean res = kafkaService.updateLocation(coordinates);
        return new ResponseEntity<>(res.booleanValue() , HttpStatus.OK) ;
    }
}
