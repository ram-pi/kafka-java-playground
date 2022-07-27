package io.confluent.developer.spring.vanilla;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.confluent.developer.spring.model.Weather;

@Service
public class AvroProducer {

	private static final Logger logger = LoggerFactory.getLogger(AvroProducer.class);
	private static final String TOPIC = "weather";

	@Autowired
	Producer<String, Weather> avroWeatherProducer;

	public void sendMessage(Weather w) {
		logger.info("### avro producer - sendMessage ###");
		avroWeatherProducer.send(new ProducerRecord<String, Weather>(TOPIC, w));
	}

}
