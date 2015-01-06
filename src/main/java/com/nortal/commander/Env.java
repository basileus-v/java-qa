package com.nortal.commander;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Env implements Command {

    @Override
    public String execute(List<String> arguments, Environment environment) {
        List<String> result = new ArrayList<>();
        for (String key : environment.getProperties().keySet()) {
            String value = environment.getProperties().get(key);
            result.add(key + "=" + value);
        }
        return StringUtils.join(result, System.lineSeparator());
    }

}
