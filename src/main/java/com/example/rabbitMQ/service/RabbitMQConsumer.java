package com.example.rabbitMQ.service;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbitMQ.exception.InvalidMessageException;
import com.example.rabbitMQ.model.Message;

@Component
public class RabbitMQConsumer {
	private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);
	private CountDownLatch latch = new CountDownLatch(1);
	
	@RabbitListener(queues = "${com.example.rabbitMQ.queue}")
	public void receivedMessage(Message message) throws InvalidMessageException {				
		logger.info("Recieved Message From RabbitMQ: " + message);
		
		if (message.getPrice() < 0) {
			throw new InvalidMessageException();			
		}else {
			System.out.println("Received " + message);
			latch.countDown();
		}
	}
	
	public CountDownLatch getLatch() {
		return latch;
	}
}
