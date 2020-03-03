package com.sscode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ssharma6757 on 12/29/2019.
 */
@RestController
public class ProducerController {

    @Autowired
    private KafkaProducerMainClass kafkaProducerMainClass;

    @PostMapping("/message")
    public void sendMessage(@RequestBody String requestMessage){
        kafkaProducerMainClass.produceMessage(requestMessage);
    }
}
