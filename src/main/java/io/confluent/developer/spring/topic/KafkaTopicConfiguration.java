package io.confluent.developer.spring.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

	@Bean
	public NewTopic compactUserTopic() {
		/*
		 * Auto create compacted topic at startup (https://developer.confluent.io/learn-kafka/architecture/compaction/)
		 */
		return TopicBuilder.name("users").partitions(6).replicas(3).compact().build();
	}

	@Bean
	public NewTopic clickTopic() {
		/*
		 * Auto create compacted topic at startup (https://developer.confluent.io/learn-kafka/architecture/compaction/)
		 */
		return TopicBuilder.name("weather").partitions(1).replicas(3).build();
	}
}
