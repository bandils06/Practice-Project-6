package com.fileManipulation;

//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
import java.nio.file.*;
//import java.util.Arrays;
//import java.util.List;
import java.util.*;

public class FileManipulation {
	static Scanner sc = new Scanner(System.in);
	
	//Get all file names from a folder.
	public void getFileNames(String path) {
		File defaultFolder = new File(path);
		File[] fileNames = defaultFolder.listFiles();
		
		//by default it will be printing in ascending order.
		for(File file: fileNames)
			System.out.println(file);
	}
	
	//Create file through File class
	public void createFile(String fileName) throws IOException {
		//give path to create file along with 'filename.txt'
		File file = new File("E:\\FilesDemo\\"+fileName);
		
		if (file.createNewFile()) {
			System.out.println("File is created.");
		} else {
			System.out.println("File already exists.");
		}
	}
	
	// Writes or update data by using NIO class.
	public void writeUpdateFile(String fileName, String content) throws IOException {
		//get path to perform operation
		Path path = Paths.get("E:\\FilesDemo\\"+fileName);
		byte arr[] = content.getBytes();// converts string content to byte array
		
		Files.write(path, arr, StandardOpenOption.APPEND);
		System.out.println("Data written/updated successfully.");
	}
	
	//Reads through FileReader class.
	public void readFile(String fileName) throws IOException {
		FileReader file = new FileReader("E:\\FilesDemo\\"+fileName);
		int data;
		
		while ((data = file.read()) != -1)
			System.out.print((char)data);
		
		file.close();
	}
	
	//Delete file if exists.
	public void deleteFile(String name) {		
		try {
			
			Path path= Paths.get("E:\\FilesDemo\\"+name);
			if(Files.deleteIfExists(path))
				System.out.println("File deleted");
			else
				System.out.println("File not exist");
			
		} catch (IOException e) {
			System.out.println(e);
		} 
	}
}
