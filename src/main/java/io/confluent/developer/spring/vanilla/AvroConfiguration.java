package io.confluent.developer.spring.vanilla;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.confluent.developer.spring.model.Weather;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.monitoring.clients.interceptor.MonitoringInterceptorConfig;

@Configuration
public class AvroConfiguration {

	@Value("${spring.kafka.properties.bootstrap.servers}")
	String bootstrapServers;

	@Value("${spring.kafka.properties.sasl.jaas.config:}")
	String saslJaasConfig;

	@Value("${spring.kafka.properties.schema.registry.url:}")
	String schemaRegitryUrl;

	@Value("${spring.kafka.properties.basic.auth.credentials.source:}")
	String basicAuthCred;

	@Value("${spring.kafka.properties.basic.auth.user.info:}")
	String basicAuthUserInfo;

	@Value("${spring.kafka.properties.security.protocol:}")
	String securityProtocol;

	@Bean
	public Producer<String, Weather> avroWeatherProducer() {
		Map<String, Object> props = generateProps();
		// Producer Monitoring interceptor
		//		props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,
		//				"io.confluent.monitoring.clients.interceptor.MonitoringProducerInterceptor");

		String monitoringInterceptorBootstrapServers = bootstrapServers;
		props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,
				"io.confluent.monitoring.clients.interceptor.MonitoringProducerInterceptor");
		props.put(MonitoringInterceptorConfig.MONITORING_INTERCEPTOR_PREFIX + ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
				monitoringInterceptorBootstrapServers);

		return new KafkaProducer<String, Weather>(props);
	}

	@Bean
	public KafkaConsumer<String, Weather> avroWeatherConsumer() {
		Map<String, Object> props = generateProps();

		// Monitoring interceptor configuration
		// ConsumerTimestampsInterceptor: enables consumer applications to resume where they left off after a datacenter failover when using Confluent Replicator
		// MonitoringConsumerInterceptor: enables streams monitoring in Confluent Control Center
		String monitoringInterceptorBootstrapServers = bootstrapServers;
		props.put(ConsumerConfig.INTERCEPTOR_CLASSES_CONFIG,
				"io.confluent.monitoring.clients.interceptor.MonitoringConsumerInterceptor");
		props.put(MonitoringInterceptorConfig.MONITORING_INTERCEPTOR_PREFIX + ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
				monitoringInterceptorBootstrapServers);
		// create consumer
		KafkaConsumer<String, Weather> consumer = new KafkaConsumer<>(props);
		return consumer;
	}

	private Map<String, Object> generateProps() {
		Map<String, Object> props = new HashMap<>();
		// Both Producer - Consumer 
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put("schema.registry.url", schemaRegitryUrl);
		props.put("basic.auth.credentials.source", basicAuthCred);
		props.put("basic.auth.user.info", basicAuthUserInfo);
		props.put("sasl.jaas.config", saslJaasConfig);
		props.put("security.protocol", securityProtocol);
		props.put("sasl.mechanism", "PLAIN");

		// Producer
		props.put(ProducerConfig.ACKS_CONFIG, "-1");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);

		// Consumer
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "java-vanilla-consumer");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		return props;
	}

}
