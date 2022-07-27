package io.confluent.developer.spring.interceptor;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

public class CustomConsumerInterceptor implements ConsumerInterceptor<String, Object> {

	@Override
	public void configure(Map<String, ?> configs) {
		// TODO Auto-generated method stub

	}

	@Override
	public ConsumerRecords<String, Object> onConsume(ConsumerRecords<String, Object> records) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCommit(Map<TopicPartition, OffsetAndMetadata> offsets) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
