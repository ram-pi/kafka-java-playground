# Java/Spring Boot Kafka Clients

## Confluent Dev Env with Confluent CLI
https://docs.confluent.io/confluent-cli/current/overview.html

To launch a local Confluent environment:
```
confluent local services start
```

## Run
The application exposes two rest APIs that produce events on the confluent local instance.
```
mvn spring-boot:run
# make some few requests
curl --request POST \
  --url http://localhost:9001/kafka/users/publish \
  --header 'content-type: multipart/form-data' \
  --form age=31 \
  --form name=Bob

curl --request POST \
  --url http://localhost:9001/kafka/weather/publish \
  --header 'content-type: multipart/form-data' \
  --form station=rome \
  --form temperature=31
```

## Classical Producer/Consumer
Packages:
```
io.confluent.developer.spring.producer
io.confluent.developer.spring.consumer
````

## Avro Producer/Consumer
Package: `io.confluent.developer.spring.vanilla`

## Interceptor
To add c3 monitoring interceptor add these properties to your consumer configuration:
```
String monitoringInterceptorBootstrapServers = bootstrapServers;
		props.put(ConsumerConfig.INTERCEPTOR_CLASSES_CONFIG,
				"io.confluent.monitoring.clients.interceptor.MonitoringConsumerInterceptor");
		props.put(MonitoringInterceptorConfig.MONITORING_INTERCEPTOR_PREFIX + ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
				monitoringInterceptorBootstrapServers);
```
and to your producer
```
String monitoringInterceptorBootstrapServers = bootstrapServers;
		props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,
				"io.confluent.monitoring.clients.interceptor.MonitoringProducerInterceptor");
		props.put(MonitoringInterceptorConfig.MONITORING_INTERCEPTOR_PREFIX + ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
				monitoringInterceptorBootstrapServers);
```
Your `pom.xml` need to contain also
```
<dependency>
  <groupId>io.confluent</groupId>
  <artifactId>monitoring-interceptors</artifactId>
  <version>${confluent.version}</version>
</dependency>
```

## Performance Tests
If you want to check which data are sent to your c3 instance run:  `control-center-console-consumer PATH_TO_C3_PROPERTIES/control-center.properties --topic _confluent-monitoring --from-beginning`.


You can also run some tests with `kafka-producer-perf-test` or `kcat`, in this case you should download librdkafka interceptor library (take a look to [https://docs.confluent.io/5.4.0/control-center/installation/clients.html#librdkafka-based-clients](https://docs.confluent.io/5.4.0/control-center/installation/clients.html#librdkafka-based-clients))
