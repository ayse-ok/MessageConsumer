package com.example.rabbitMQ.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Message.class)
public class Message {
	private String content;
	private Integer messageId;
	
	@Override
	public String toString() {
		return "Message [content=" + content + ", messageId=" + messageId + "]";
	}
	
}
