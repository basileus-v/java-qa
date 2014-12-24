package com.nortal.commander;

import java.util.List;

public class Env implements Command{

	@Override
	public void execute(List<String> arguments, Environment environment) {
		for (String key : environment.getMap().keySet()) {
    	    String value = environment.getMap().get(key);
    	    System.out.println(key + "=" + value);
    	}
		
	}

}
