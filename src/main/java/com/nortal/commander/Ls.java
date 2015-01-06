package com.nortal.commander;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ls implements Command {

    @Override
    public String execute(List<String> arguments, Environment environment) {
        File baseDirectory = getBaseDirectory(arguments);
        if (baseDirectory == null) {
            return "Directory does not exist.";
        }
        return listDirectory(baseDirectory);
    }

    protected File getBaseDirectory(List<String> arguments) {
        if (arguments.isEmpty()) {
            String workingDir = System.getProperty("user.dir");
            return new File(workingDir);
        }
        File dir = new File(arguments.get(0));
        if (!dir.exists()) {
            return null;
        }
        return dir;
    }

    protected static String listDirectory(File currentDir) {
        File[] files = currentDir.listFiles();
        List<String> fileNames = new ArrayList<>();
        for (File file : files) {
            fileNames.add(file.getName() + (file.isDirectory() ? "/" : ""));
        }
        return StringUtils.join(fileNames, System.lineSeparator());

    }

}
