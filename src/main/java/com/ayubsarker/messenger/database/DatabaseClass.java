/**
 *  @author Md. Ayub Ali Sarker, email:ayub.ali.sarker@gmail.com
 *  File Name: DatabaseClass.java
 *  Date Created: 5:48:35 pm,2015
 */
package com.ayubsarker.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.ayubsarker.messenger.model.Message;
import com.ayubsarker.messenger.model.Profile;

public class DatabaseClass {
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
