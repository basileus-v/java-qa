package com.nortal.commander;

import org.joda.time.Period;

import java.text.DecimalFormat;
import java.util.List;

public class Uptime implements Command {

    @Override
    public String execute(List<String> arguments, Environment environment) {
        long start = environment.getStartTime();
        long end = System.currentTimeMillis();
        Period period = new Period(start, end);
        DecimalFormat df = new DecimalFormat("00");
        return df.format(period.getHours()) + ":" + df.format(period.getMinutes()) + ":" + df.format(period.getSeconds());
    }

}
