package io.confluent.developer.spring.interceptor;

import java.util.Map;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class CustomProducerInterceptor implements ProducerInterceptor<String, Object> {

	@Override
	public void configure(Map<String, ?> configs) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProducerRecord<String, Object> onSend(ProducerRecord<String, Object> record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
