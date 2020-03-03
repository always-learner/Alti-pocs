package com.sscode;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by ssharma6757 on 12/29/2019.
 */

@Component
public class KafkaProducerMainClass {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerMainClass.class);

    public void produceMessage(final String message){
        LOGGER.info("Sending message to kafka producer "+message);

        final Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        final Producer<String, String> producer = new KafkaProducer<>(properties);

        final ProducerRecord<String, String> record = new ProducerRecord<String, String>("first_topic", message);
        producer.send(record, (recordMetadata, e) -> {
            if (e == null){
                LOGGER.info("Message sent with details \n"+ recordMetadata);

            } else {
                LOGGER.error("Error while sending message ", e);
            }
        });

        producer.flush();
        producer.close();

    }
}
