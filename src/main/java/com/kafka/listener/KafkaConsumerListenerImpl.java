package com.kafka.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerListenerImpl {

    @Value("${spring.kafka.topic}")
    public String topic;

    @KafkaListener(topics = "#{__listener.topic}", groupId = "my-consumer-group")
    public void consumeMessage(ConsumerRecord<String, String> record) {
        log.info("Received Message: Key = [{}], Value = [{}], Partition = [{}], Offset = [{}]",
                record.key(), record.value(), record.partition(), record.offset());
    }
}
