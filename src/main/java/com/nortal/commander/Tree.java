package com.nortal.commander;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Tree implements Command{

	@Override
	public void execute(List<String> arguments, Environment environment) {
			
				String workingDir = System.getProperty("user.dir");
			      File currentDir = new File(workingDir);
			      displayDirectoryContents(currentDir);
	}
	
	private static void displayDirectoryContents(File currentDir) {
		File[] files = currentDir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				if(!file.getAbsolutePath().equals(file.getParent())) {
				System.out.println("|   |--" + file.getName());
				displayDirectoryContents(file);
				}
				System.out.println("|-" + file.getName());
				displayDirectoryContents(file);
			} else if (file.getParent().equals(System.getProperty("user.dir"))) {
				System.out.println("|-" + file.getName());
				
			} else {
				System.out.println("|       |--" + file.getName());
			}
		}
		
	}

}
