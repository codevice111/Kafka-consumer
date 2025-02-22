package com.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumerListenerService {
    void consumeMessage(ConsumerRecord<String, String> record);
}
