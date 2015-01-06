package com.nortal.commander;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CurrentDate implements Command {

    @Override
    public String execute(List<String> arguments, Environment environment) {
        return new SimpleDateFormat("EEEE, d. MMMM yyyy, HH:mm", new Locale("et")).format(new Date());
    }
}
