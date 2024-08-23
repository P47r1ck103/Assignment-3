package com.coderscampus.assignment3;

import java.util.Scanner;

public class UserLoginApplication {

//	private static Object user;

	public static void main(String[] args) throws Exception  {
		UserService userService = new UserService("data.txt");
		Scanner scanner = new Scanner(System.in);
		int attempts = 0;
		int maxAttempts = 5;

		while (attempts < maxAttempts) {
			System.out.println("Enter your email: ");
			String email = scanner.nextLine();

			System.out.println("Enter your password: ");
			String password = scanner.nextLine();

			User user = UserService.validateLogin(email, password);

			if (user != null) {
				System.out.println("Welcome " + ((User) user).getName() + ".");

				return; // exit the program after successful login attempt
			} else {// if login fails
				attempts++;// Increment the number of failed attempts
				if (attempts < maxAttempts) {
					System.out.println("invalid login, please try again");
				}
			}
		
		}
		{
			System.out.println("Too many failed login attempts, you are now locked out.");
			scanner.close();
		}

	}
}