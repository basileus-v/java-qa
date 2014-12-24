package com.nortal.commander;

import java.lang.management.ManagementFactory;
import java.util.List;

import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public class Uptime implements Command {
	
	
	
	@Override
	public void execute(List<String> arguments, Environment environment) {
//		RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
//		long uptime = rb.getUptime();
		
//		long second = (uptime / 1000) % 60;
//		long minute = (uptime / (1000 * 60)) % 60;
//		long hour = (uptime / (1000 * 60 * 60)) % 24;

//		String time = String.format("%02d:%02d:%02d", hour, minute, second);
//		System.out.println(time);
		
//		final Period vmUptime = new Period(ManagementFactory.getRuntimeMXBean().getUptime()).normalizedStandard(PeriodType.yearDayTime());
//		final PeriodFormatter pf = new PeriodFormatterBuilder()
//				.printZeroAlways()
//				.minimumPrintedDigits(2)
//				.appendHours().appendLiteral(":").appendMinutes().appendLiteral(":").appendSeconds()
//				.toFormatter();
//		System.out.println(String.format("%s", pf.print(vmUptime)));
		
		long start = environment.getStartTime();
		long end = System.currentTimeMillis();
		Period period = new Period(start,end);
		System.out.printf("%02d:%02d:%02d\n", period.getHours(), period.getMinutes(), period.getSeconds());
		
	}
	
}
