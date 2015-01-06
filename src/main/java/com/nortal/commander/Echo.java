package com.nortal.commander;

import java.io.*;
import java.util.List;


public class Echo implements Command {
    @Override
    public String execute(List<String> arguments, Environment environment) {
        Writer writer;
        int i = arguments.indexOf(">");
        if (i > -1) {
            try {
                writer = new PrintWriter(arguments.get(i + 1), "UTF-8");
            } catch (FileNotFoundException e) {
                return "Error writing to file";
            } catch (UnsupportedEncodingException e) {
                return "Error writing to file";
            }
        } else {
            writer = new StringWriter();
        }

        int k;
        int lastArgumentIndex = i < 0 ? arguments.size() : i;
        for (k = 0; k < lastArgumentIndex; k++) {
            String resolvedArgument = arguments.get(k);
            if (resolvedArgument.startsWith("$")) {
                String key = resolvedArgument.substring(1);
                resolvedArgument = environment.getProperties().get(key);
            }
            try {
                writer.write(resolvedArgument + " ");
            } catch (IOException e) {
                return "Error writing to file";
            }
        }

        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (writer instanceof StringWriter) {
            return writer.toString();
        }
        return "Output is redirected to file";
    }

}