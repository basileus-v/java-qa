package com.nortal.commander;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Ls implements Command{

	@Override
	public void execute(List<String> arguments, Environment environment) {
			if(arguments.isEmpty()){
				String workingDir = System.getProperty("user.dir");
			      File currentDir = new File(workingDir);
			      displayDirectoryContents(currentDir);
			} else {
				String givenDir = arguments.get(0);
				File currentDir = new File(givenDir);
				if (!currentDir.exists()) {
					try {
						throw new FileNotFoundException("No files in given directory");
					} catch (FileNotFoundException e) {
						System.out.println("Provide correct path: c:\\path\\to\\dir");
					}
				} else {
					displayDirectoryContents(currentDir);
				}
			    
			} 
	      
		
	}
	
	private static void displayDirectoryContents(File currentDir) {
		File[] files = currentDir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				System.out.println("directory:" + file.getName());
				displayDirectoryContents(file);
			} else {
				System.out.println("     file:" + file.getName());
			}
		}
		
	}

}
