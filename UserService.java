package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

	private static List<User> users;

//	constructor to read data from file and create array
	public UserService(String filename) throws IOException {
		users = new ArrayList<>();
		BufferedReader fileReader = null;
		fileReader = new BufferedReader(new FileReader("data.txt"));
		String line;
	while ((line = fileReader.readLine()) != null) {
		String[] parts = line.split(",");
		if (parts.length == 3) {
			String username = parts[0];
			String password = parts[1];
			String name = parts[2];
			users.add(new User (username, password, name));
		}
	}
//		 fileReader = new BufferedReader(new FileReader("data.txt")); 
//		 	String line;
//			while ((line = reader.readLine()) != null) {
//				String[] parts = line.split(",");
//				if (parts.length == 3) {
//					users.add(new User(parts[0], parts[1], parts[2]));// Create a User object from file data
//				}
//			}
		}
		
	

	public static User validateLogin(String email, String password) {
		for (User user : users) {
			if (user.getUsername().equals(email) && user.getPassword().equals(password)) {
				return user;// Return matching User.
			}
		}
		return null; // return null if no match is found
	}

}