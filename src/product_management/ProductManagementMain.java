package product_management;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import common.DBUtils;

public class ProductManagementMain {

	public void productManagement() throws IOException, SQLException { // Entry point => User defined Method

		System.out.println(" #############  Welcome to Product Management ########## ");

		Scanner sc = new Scanner(System.in);

		boolean shallIKeepRunningCode = true;

		Product product = new Product(); // Object

		while (shallIKeepRunningCode) {

			System.out.println("     What would you like to do today ?");
			System.out.println("        1. Add Product");
			System.out.println("        2. Update Product");
			System.out.println("        3. Search Product");
			System.out.println("        4. Delete Product");
			System.out.println("        5. Print Product");
			System.out.println("        9. Exit");

			int option = sc.nextInt();

			switch (option) {
			case 1:
				System.out.println("          Add Product :");
				System.out.println("             Enter Product name :");
				product.name = sc.next();

				System.out.println("             Enter Product quantity :");
				product.quantity = sc.nextInt();

				System.out.println("             Enter price :");
				product.price = sc.next();

				System.out.println("         ***** Product added succefully");

				String query = "insert in to product (name, quantity, price) values ('" + product.name + "', "
						+ product.quantity + ", '" + product.price + "')";

				DBUtils.executeQuery(query);

				break;
			case 2:

				System.out.println("          Update Product :");
				System.out.println("             Enter Product name to update:");

				Scanner scToUpdate = new Scanner(System.in);
				String productNameToUpdate = scToUpdate.next();

				String selectQuery = "Select count(*) from product where name='"+productNameToUpdate+"'";

				ResultSet rs = DBUtils.executeSelectQuery(selectQuery);
				rs.next();
				int countOfProduct = rs.getInt(0);

				if (countOfProduct == 1) {
					scToUpdate = new Scanner(System.in);

					System.out.println("Updated product name");
					String updatedProductName = scToUpdate.next();

					System.out.println("Updated product quantity");
					int updatedQty = scToUpdate.nextInt();

					System.out.println("Updated product price");
					String updatedProductPrice = scToUpdate.next();

					String productUpdateQuery = "update prodict set name='" + updatedProductName + "', quantity="
							+ updatedQty + ", price='" + updatedProductPrice + "' where name='" + productNameToUpdate
							+ "'";
				} else {
					System.out.println("Product Not found");
				}
				
				break;
				
			case 3:
				System.out.println("          Search Product :");
				System.out.println("             Enter Product name to search:");

				Scanner scToSearch = new Scanner(System.in);
				String productNameToSearch = scToSearch.next();

				String selectQueryForSearch = "Select * from product where name='"+productNameToSearch+"'";
				ResultSet searchResultSet = DBUtils.executeSelectQuery(selectQueryForSearch);

				while (searchResultSet.next()) {
					System.out.println(searchResultSet.getString(1)+" "+searchResultSet.getString(2)+" "+searchResultSet.getString(3));
				}
				
				break;
				
			case 4:

				System.out.println("          Delete Product :");
				System.out.println("             Enter Product name to Delete:"); // Shorpner

				Scanner scToDelete = new Scanner(System.in);
				String productNameToDelete = scToDelete.next();

				String deleteQuery = "delete from product where name='"+productNameToDelete+"'";
				DBUtils.executeQuery(deleteQuery);
				
				break;
				
			case 5:
				String selectAllQueryForSearch = "Select * from product";
				ResultSet printResultSet = DBUtils.executeSelectQuery(selectAllQueryForSearch);

				while (printResultSet.next()) {
					System.out.println(printResultSet.getString(1)+" "+printResultSet.getString(2)+" "+printResultSet.getString(3));
				}

				break;
				
			case 9:
				System.out.println("Exiting the product management...");
				shallIKeepRunningCode = false;
				break;
				
			default:
				System.out.println("Unknown option");
			}
		}
	}

}
