package com.secure.qa.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class TimeUtil {
	
	public static synchronized String getCurrentDate() {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
        return sdf.format(cal.getTime());
	}
	
	public static synchronized String getCurrentDate(String format) {
		DateFormat sdf = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
        return sdf.format(cal.getTime());
	}

	public static synchronized String getFutureDate(String format, int days) {
		DateFormat sdf = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, days);
        return sdf.format(cal.getTime());
	}
	
	public static synchronized long getEpochTime() {
		return getEpochTime(getCurrentDate("MMM dd yyyy HH:mm:ss.SSS z"));
	}
	
	public static synchronized long getEpochTime(String time) {
		String format = "MMM dd yyyy HH:mm:ss.SSS z";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		ZonedDateTime zdt = ZonedDateTime.parse(time, dtf);
		return zdt.toInstant().toEpochMilli()/1000;
	}
}
