package com.nortal.commander;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main{
	
		public static void main(String[] args) {
		      Scanner scanner = new Scanner(System.in);
		      Environment environment = new Environment();
	      
		        while(true) {
		        	System.out.print("# ");
		            String line = scanner.nextLine();
		            if(line.equals("exit")){
		                break;
		            }
		            Command command = getCommand(line);
		            if(command != null){
			            command.execute(getArguments(line), environment);
		            } else {
		            	System.out.println("No such command! " + line);
		            }
		        }
		        
		  }

			          
		private static Command getCommand(String line) {
					if(line.startsWith("echo ")) {
						return new Echo();
					} else if(line.startsWith("export")){
						return new Export();
					} else if(line.startsWith("env")){
						return new Env();
					} else if(line.startsWith("uptime")){
						return new Uptime();
					} else if(line.startsWith("date")){
						return new CurrentDate();
					} else if(line.startsWith("ls")){
						return new Ls();
					} else if(line.startsWith("cat")){
						return new Cat();
					} else if(line.startsWith("tree")){
						return new Tree();
					}
					  else {
						return null;
					}
				}
		
				
		private static List<String> getArguments(String line) {
				List<String> words = new ArrayList<String>();
				Scanner sc = new Scanner(line);
				sc.next();
				while(sc.hasNext()) {
							words.add(sc.next());
						}
					return words;
					   
					}
		


		
		}
		  
		  