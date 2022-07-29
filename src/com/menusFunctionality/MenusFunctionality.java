package com.menusFunctionality;
import com.menus.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.fileManipulation.*;

public class MenusFunctionality {
	static Menus obj = new Menus();
	static FileManipulation file = new FileManipulation();
	static Scanner sc = new Scanner(System.in);
	
	public void mainMenuFunctionality(int choice) {
		switch (choice) {
		//1. Retrieve current file name in ascending order.
		case 1:
			String defaultPath = "E:\\FilesDemo";
			file.getFileNames(defaultPath);
			
			obj.optionsSelection();
			break;
			
		//2. Bussiness Level Operation Menu.
		case 2:
			int choice2 = obj.bussinessLevelOperationMenu();
			bLOFunctionality(choice2);
			break;
			
		//3. Exit form the Application.
		case 3:
			System.out.println("Thankyou!...\nExiting...");
			break;
		default:
			System.out.println("Invalid input...\nPlease try again!...");
		}
	}
	
	//Bussiness Level Operation Menu Functionality.
	static void bLOFunctionality(int choice) {
		switch (choice) {
		
		//1. Add a file and its content to the directory.
		case 1:
			System.out.println("Enter file name: ");
			String fileName = sc.next();
			try {
				file.createFile(fileName);
				sc.nextLine();
				
				System.out.println("Enter data you want to enter/update: ");
				String content = sc.nextLine();
				file.writeUpdateFile(fileName, content);
			} catch (IOException e) {
				System.out.println("Error: "+e);
			} finally {
				bLOFunctionality(obj.bussinessLevelOperationMenu());
			}
			break;
			
		//2. Delete a file from a directory.
		case 2:
			System.out.println("Enter file name to delete: ");
			String name = sc .next();
			file.deleteFile(name);
			bLOFunctionality(obj.bussinessLevelOperationMenu());
			break;
			
		//3. Searching a file and show its content.	
		case 3:
			System.out.println("Enter file name: ");
			String fileName1 = sc.next();
			Path paths = Paths.get("E:\\FilesDemo\\"+fileName1);
			if(Files.exists(paths)) {
				try {
					file.readFile(fileName1);
					System.out.println("\nData Retrieved Successfully...");
				} catch (IOException e) {
					System.out.println("Error: "+e);
				} 
			} else System.out.println("File not exits...");
			bLOFunctionality(obj.bussinessLevelOperationMenu());
			break;
			
		//4. Exit from BLO menu.	
		case 4:
			obj.optionsSelection();
			break;
		default:
			System.out.println("Invalid input...\nPlease try again!...");
		}
	}
}
