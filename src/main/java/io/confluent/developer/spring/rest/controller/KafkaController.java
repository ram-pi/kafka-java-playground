package io.confluent.developer.spring.rest.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.confluent.developer.spring.model.Weather;
import io.confluent.developer.spring.producer.Producer;
import io.confluent.developer.spring.vanilla.AvroProducer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

	@Autowired
	Producer producer;

	@Autowired
	AvroProducer avroProducer;

	@PostMapping(value = "/users/publish")
	/*
	 * curl --request POST --url http://localhost:9000/kafka/publish --header 'content-type: multipart/form-data' --form age=33 --form name=pier
	 */
	public void sendMessageToKafkaTopic(@RequestParam("name") String key, @RequestParam("age") String message) {
		this.producer.sendMessage(key, message);
	}

	@PostMapping(value = "/weather/publish")
	public void sendWeatherToKafkaTopic(@RequestParam("station") String station,
			@RequestParam("temperature") int temperature) {
		Weather w = new Weather(station, Instant.now().toEpochMilli(), temperature);
		avroProducer.sendMessage(w);
	}
}