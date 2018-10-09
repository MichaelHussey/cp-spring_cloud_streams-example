package io.confluent.examples.scs_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.binder.kafka.config.KafkaBinderConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(KafkaBinderConfiguration.class)
public class ScsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScsDemoApplication.class, args);
	}
}
