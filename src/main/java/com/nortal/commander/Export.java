package com.nortal.commander;

import java.util.List;


public class Export implements Command{
	
	@Override
	public void execute(List<String> arguments, Environment environment) {
			for (String actualElement : arguments) {
				environment.addElementToMap(actualElement.split("=")[0],
			            actualElement.split("=")[1]);
			}
			
	}
	

}
