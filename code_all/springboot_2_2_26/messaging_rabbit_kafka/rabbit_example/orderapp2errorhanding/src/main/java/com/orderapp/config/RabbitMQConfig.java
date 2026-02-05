package com.orderapp.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	public static final String ORDER_QUEUE = "order.queue";
	public static final String ORDER_EXCHANGE = "order.exchange";
	public static final String ORDER_ROUTINGKEY = "order.routingkey";

	// DLQ constants
	public static final String DLQ_QUEUE = "order.dlq";
	public static final String DLQ_EXCHANGE = "order.dlq.exchange";
	public static final String DLQ_ROUTING_KEY = "order.dlq.routingkey";

	// 1️⃣ Main Queue (now DLQ-enabled, still backward compatible)
	@Bean
	public Queue orderQueue() {
		return QueueBuilder.durable(ORDER_QUEUE)
				.withArgument("x-dead-letter-exchange", DLQ_EXCHANGE)
				.withArgument("x-dead-letter-routing-key", DLQ_ROUTING_KEY).build();
	}

	// 2️⃣ Main Exchange
	@Bean
	public TopicExchange orderExchange() {
		return new TopicExchange(ORDER_EXCHANGE);
	}

	// 3️⃣ Main Binding
	@Bean
	public Binding orderBinding(Queue orderQueue, TopicExchange orderExchange) {
		return BindingBuilder.bind(orderQueue).to(orderExchange).with(ORDER_ROUTINGKEY);
	}

	// 4️⃣ Dead Letter Exchange
	@Bean
	public DirectExchange deadLetterExchange() {
		return new DirectExchange(DLQ_EXCHANGE);
	}

	// 5️⃣ Dead Letter Queue
	@Bean
	public Queue deadLetterQueue() {
		return QueueBuilder.durable(DLQ_QUEUE).build();
	}

	// 6️⃣ DLQ Binding
	@Bean
    public Binding deadLetterBinding() {
        return BindingBuilder
                .bind(deadLetterQueue())
                .to(deadLetterExchange())
                .with(DLQ_ROUTING_KEY);
    }
	// 7️⃣ Message Converter (shared)
    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    // 8️⃣ RabbitTemplate (producer uses this, consumer ignores it)
    @Bean
    public AmqpTemplate amqpTemplate(
            ConnectionFactory connectionFactory,
            MessageConverter converter) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter);
        return rabbitTemplate;
    }
}