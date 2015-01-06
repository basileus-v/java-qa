package com.nortal.commander;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.List;

public class Tree implements Command {

    @Override
    public String execute(List<String> arguments, Environment environment) {
        File baseDirectory = getBaseDirectory(arguments);
        if (baseDirectory == null) {
            return "Directory does not exist.";
        }
        return displayDirectoryContents(baseDirectory, 1);
    }

    private File getBaseDirectory(List<String> arguments) {
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

    private static String displayDirectoryContents(File parent, int level) {
        File[] files = parent.listFiles();
        String result = "";
        for (File file : files) {
            String line = "";
            line += StringUtils.repeat("|   ", level - 1);
            line += "|-- " + file.getName();
            result += line + System.lineSeparator();
            if (file.isDirectory()) {
                result += displayDirectoryContents(file, level + 1);
            }

        }
        return result;
    }
}
