package com.nortal.commander;

import java.util.List;

public interface Command {
    void execute(List<String> arguments, Environment environment);
}
