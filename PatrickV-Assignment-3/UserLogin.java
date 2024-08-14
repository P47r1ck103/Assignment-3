package com.coderscampus.assignment3;

import java.util.Scanner;

public class UserLogin {
	
//	simulate reading user data from a file and storing it in an array
	private static User[] userDatabase = new User[] {
			new User("test@email.com","passwordTest!1", "Test User"),
			new User("another@user.com", "asdfasdf", "Another User"),
			new User("john.doe@mydomain.net", "hdk398jfl", "John Doe"),
			new User("jane.doe@myotherdomain.com", "sunrise-sunset", "Jane Doe")
	};
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		prompting the user for username (email) and password
		System.out.println("Enter your email: ");
		String email = scanner.nextLine();
		
		System.out.println("Enter your password: ");
		String password = scanner.nextLine();
		
//		validating the username/password combination
		User user = validateLogin(email, password);
		if (user != null) {
			System.out.println("Login successful! Welcome, " + user.getName() + "!");
		} else {
			System.out.println("Invalid email or password. Please try again.");
			scanner.close();
		}
		
		
	}
	

//method to validate the username and password
private static User validateLogin(String email, String password) {
	for (User user : userDatabase) {
		if (user.getUsername().equals(email) && user.getPassword().equals(password)) {
			return user;
		}
	}
	return null; // return null if no match is found
}

}
