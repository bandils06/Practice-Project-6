package com.menus;

import java.util.Scanner;
import com.menusFunctionality.*;

public class Menus {
	Scanner sc = new Scanner(System.in);
	MenusFunctionality obj = new MenusFunctionality();
	
	public void optionsSelection() {
        String[] arr = {"1. Retrive current filename in ascending order.",
                "2. Bussiness Level Operation Menu.",
                "3. Exit form the Application.",
                };
                
        for(String i: arr)
            System.out.println(i);
        
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        obj.mainMenuFunctionality(choice);
	}
	
	public int bussinessLevelOperationMenu() {
        String[] arr = {"1. Add a file and its content to the directory.",
                "2. Delete a file from a directory.",
                "3. Searching a file and show its content.",
                "4. Exit from BLO menu."
                };
                
        for(String i: arr)
            System.out.println(i);
        
        System.out.println("Enter your choice: ");
        return sc.nextInt();
	}
	
}
