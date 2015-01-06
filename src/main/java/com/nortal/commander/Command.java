package com.nortal.commander;

import java.util.List;

public interface Command {
    String execute(List<String> arguments, Environment environment);
}
