package com.tech.config;

import com.tech.constant.KafkaConstant;
import com.tech.dto.EmployeeDTO;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProduceConfig {
	@Bean
	public ConsumerFactory<String, EmployeeDTO> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.HOST);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstant.GROUP_ID);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
				new JsonDeserializer<>(EmployeeDTO.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, EmployeeDTO> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, EmployeeDTO> factory = new ConcurrentKafkaListenerContainerFactory<String, EmployeeDTO>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	@Bean
	public ProducerFactory<String, EmployeeDTO> producerFactory() {
		Map<String, Object> configProps = new HashMap<String, Object>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.HOST);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	@Bean(name = "kafkaTemplate")
	public KafkaTemplate<String, EmployeeDTO> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	@Bean
	public NewTopic myTopic() {
		return TopicBuilder.name("new-customer")
				.partitions(1) // Set the number of partitions
				.replicas(1)   // Set the replication factor
				.compact()      // Enable log compaction (optional) if it then need to send by key
				.build();
	}
}