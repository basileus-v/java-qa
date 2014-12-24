package com.nortal.commander;

import java.util.Date;
import java.util.List;

public class CurrentDate implements Command {
	
	
	Date date = new Date();

	@Override
	public void execute(List<String> arguments, Environment environment) {
		 System.out.println(date.toString());	
		 
	}
   
}
