package com.nortal.commander;

import java.util.List;


public class Export implements Command {

    @Override
    public String execute(List<String> arguments, Environment environment) {
        for (String actualElement : arguments) {
            String[] keyValue = actualElement.split("=");
            environment.addProperty(keyValue[0], keyValue[1]);
        }
        return null;
    }


}
