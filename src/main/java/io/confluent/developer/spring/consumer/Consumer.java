package io.confluent.developer.spring.consumer;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics = "users")
	public void consume(ConsumerRecord<String, String> record) throws IOException {
		logger.info(String.format("#### -> Consuming message"));
		logger.info("name: " + record.key() + " age: " + record.value());
	}
}
