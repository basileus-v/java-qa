package com.nortal.commander;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Cat implements Command{

	@Override
	public void execute(List<String> arguments, Environment environment) {
		String givenDir = arguments.get(0);
		File currentDir = new File(givenDir);
		if (currentDir.exists() && givenDir.contains("/")) {
			readFromFile(currentDir);
		} else {
	
		String fileName = arguments.get(0);
		String workingDir = System.getProperty("user.dir");
	    File file = new File(workingDir + "/" + fileName);
		readFromFile(file);
		}
	}

	private void readFromFile(File file) {
		FileInputStream fis = null;
		int oneByte;
		try {
			fis = new FileInputStream(file);
			while ((oneByte = fis.read()) != -1) {
				System.out.write(oneByte);
			}
		} catch (IOException e) {
			System.out.println("no such file in current directory or path is incorrect (usage: cat C:/path/to/file/somefile.txt)!");
			
		}
		System.out.flush();
		System.out.println();
	}
}
