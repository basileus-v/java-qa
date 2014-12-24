package com.nortal.commander;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;


public class Echo implements Command {
    @Override
    public void execute(List<String> arguments, Environment environment) {
    	for(String arg : arguments){
    		if(arg.startsWith("$")){
    			String key = arg.substring(1);
    			String value = environment.getMap().get(key);
    			System.out.println(value);
    		} else if (arg.equals(">")) {
    			String fileName = arguments.get(arguments.size()-1);
    			PrintWriter writer = null;
    			
				try {
					writer = new PrintWriter(fileName, "UTF-8");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (String argum : arguments){
					if(argum.equals(">")){
						break;
					}
					else if(argum.startsWith("$")){
		    			String key2 = argum.substring(1);
		    			String value2 = environment.getMap().get(key2);
		    			writer.println(value2);
					} else {
						writer.println(argum);
					}
						
					
				}
    			
    			writer.close();
    			break;
    			
    		}
    		else if (!arguments.contains(">")){
    			System.out.print(arg + " ");
    		}
    	}
    	System.out.println("");
    }
}