/**
 *  @author Md. Ayub Ali Sarker, email:ayub.ali.sarker@gmail.com
 *  File Name: MessageService.java
 *  Date Created: 5:06:23 pm,2015
 */
package com.ayubsarker.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.ayubsarker.messenger.database.DatabaseClass;
import com.ayubsarker.messenger.exception.DataNotFoundException;
import com.ayubsarker.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "ayub.ali"));
		messages.put(2L, new Message(2, "Hello Jersey", "ayub.ali"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessagesForYear(int year) {
		List<Message> list = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			System.out.println("cal.get(Calendar.YEAR): " + cal.get(Calendar.YEAR));
			if (cal.get(Calendar.YEAR) == year) {
				list.add(message);
			}
		}
		return list;
	}

	public List<Message> getAllMessagePaginated(int start, int size) {
		List<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size()) {
			return new ArrayList<Message>();
		} else {
			return list.subList(start, start + size);
		}
	}

	public Message getMessage(long id) {

		Message message = messages.get(id);
		if (message == null) {
			throw new DataNotFoundException("Message with id " + id + " not found");
		}
		return message;
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}

}
