package ecommerce;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import product_management.ProductManagementMain;
import user_management.UserManagementMain;

public class ApplicationMain {

	public static void main(String[] args) throws IOException, SQLException {

		System.out.println(" #############  Welcome to Ecommerse ########## ");

		
		
		Scanner sc = new Scanner(System.in); // Cunstructor | in => Function

		boolean shallIKeepRunningCode = true;

		while (shallIKeepRunningCode) {
			System.out.println("     What would you like to do today ?");
			System.out.println("        1. Product Management");
			System.out.println("        2. User Management");
			System.out.println("        9. Exit");
			int option = sc.nextInt();

			System.out.println(option);

			switch (option) {
			case 1:
				ProductManagementMain pm = new ProductManagementMain();
				pm.productManagement(); // static direct class Method call
				break;
			case 2:
				UserManagementMain.userManagement(); // Method call
				break;

			case 9:
				System.out.println("Exiting the application...");
				shallIKeepRunningCode = false;
				break;
			default:
				System.out.println("Unknown option");
			}
		}
	}
}