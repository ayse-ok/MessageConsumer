package com.example.rabbitMQ.service;

import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbitMQ.model.Message;

@Component
public class RabbitMQConsumer {
	private CountDownLatch latch = new CountDownLatch(1);
	
	@RabbitListener(queues = "${com.example.rabbitMQ.queue}")
	public void receivedMessage(Message message) {
		System.out.println("Received " + message);
		latch.countDown();
	}
	
	public CountDownLatch getLatch() {
		return latch;
	}
}
