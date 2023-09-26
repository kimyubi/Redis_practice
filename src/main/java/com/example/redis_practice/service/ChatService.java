package com.example.redis_practice.service;

import java.util.Scanner;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService implements MessageListener {

	private final RedisMessageListenerContainer container;
	private final RedisTemplate<String, String> redisTemplate;
	public void enterChatRoom(String chatRoomName){
		container.addMessageListener(this, new ChannelTopic(chatRoomName));

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			if(line.equals("q")){
				System.out.println("Quit...");
				container.removeMessageListener(this);
				break;
			}

			redisTemplate.convertAndSend(chatRoomName, line);
		}
	}

	@Override
	public void onMessage(Message message, byte[] pattern) {
		System.out.println("Message : " + message.toString());
	}
}
