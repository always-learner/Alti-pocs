package com.sscodes;

import org.apache.http.HttpHost;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;
import java.util.Collections;
import java.util.Properties;

/**
 * Created by ssharma6757 on 1/15/2020.
 */

@Component
public class KafkaClientConsumer {

    public void ConsumeMessage(){
        final Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,
                "KafkaExampleConsumer");

        final Consumer consumer = new KafkaConsumer(properties);
        consumer.subscribe(Collections.singleton("twitter-topic"));

        RestClient restClient = RestClient.builder(new HttpHost("https://qiq88y87pg:eeg10830rd@test-cluster-427149520.ap-southeast-2.bonsaisearch.net:443")).build();

        while (true) {
            final ConsumerRecords<Long, String> consumerRecords =
                    consumer.poll(Duration.ofMillis(1000));
            consumerRecords.forEach(record -> {
                try {
                    Response get = restClient.performRequest(new Request("GET", "/"));
                    System.out.println(get);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.printf("Consumer Record:(%d, %s, %d, %d)\n",
                        record.key(), record.value(),
                        record.partition(), record.offset());
            });
            consumer.commitAsync();
        }
    }

}
