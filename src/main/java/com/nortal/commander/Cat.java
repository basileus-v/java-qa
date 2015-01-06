package com.nortal.commander;

import java.io.*;
import java.util.List;

public class Cat implements Command {

    @Override
    public String execute(List<String> arguments, Environment environment) {
        return readFromFile(new File(arguments.get(0)));
    }

    private String readFromFile(File file) {
        char[] buff = new char[1024];
        StringWriter sw = new StringWriter();
        FileInputStream fis = null;
        BufferedReader bufferReader = null;
        try {
            fis = new FileInputStream(file);
            bufferReader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            int n;
            while ((n = bufferReader.read(buff)) != -1) {
                sw.write(buff, 0, n);
            }
            return sw.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sw.close();
                bufferReader.close();
            } catch (IOException e) {
                //ignore
            }
        }
        return null;
    }
}
