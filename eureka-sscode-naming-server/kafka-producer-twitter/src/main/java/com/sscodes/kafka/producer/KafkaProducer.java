package com.sscodes.kafka.producer;

import com.sscodes.twitter.client.TwitterClient;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by ssharma6757 on 1/15/2020.
 */
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private TwitterClient twitterClient = new TwitterClient();

    private KafkaClient kafkaClient = new KafkaClient();

    public void produceMessage() throws InterruptedException {
        BlockingQueue<String> msgQueue = new LinkedBlockingQueue<>(100000);
        ClientBuilder clientBuilder = this.twitterClient.getTwitterClient();
        clientBuilder.processor(new StringDelimitedProcessor(msgQueue));
        Client hosebirdClient = clientBuilder.build();
        hosebirdClient.connect();
        final Producer kafkaProducer = kafkaClient.getKafkaProducer();

        while (!hosebirdClient.isDone()) {
            String msg = msgQueue.take();
            System.out.println(msg);
            final ProducerRecord<String, String> record = new ProducerRecord<>("twitter-topic", msg);
            kafkaProducer.send(record, (recordMetadata, e) -> {
                if (e == null){
                    LOGGER.info("Message sent with details \n"+ recordMetadata);

                } else {
                    LOGGER.error("Error while sending message ", e);
                }
            });
        }
    }
}
