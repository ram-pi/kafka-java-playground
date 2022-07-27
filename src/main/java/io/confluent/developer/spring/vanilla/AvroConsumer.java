package io.confluent.developer.spring.vanilla;

import java.time.Duration;
import java.util.Arrays;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import io.confluent.developer.spring.model.Weather;

@Component
public class AvroConsumer {

	private static final String TOPIC = "weather";

	@Autowired
	KafkaConsumer<String, Weather> avroWeatherConsumer;

	private static final Logger logger = LoggerFactory.getLogger(AvroConsumer.class);

	@EventListener(ApplicationStartedEvent.class)
	public void subscribeAtStartup() {
		// subscribe 
		avroWeatherConsumer.subscribe(Arrays.asList(TOPIC));

		// poll new data
		while (true) {
			ConsumerRecords<String, Weather> records = avroWeatherConsumer.poll(Duration.ofMillis(100));

			for (ConsumerRecord<String, Weather> record : records) {
				logger.info("Key: " + record.key() + ", Value: " + record.value());
				logger.info("Partition: " + record.partition() + ", Offset:" + record.offset());
			}
		}
	}
}
