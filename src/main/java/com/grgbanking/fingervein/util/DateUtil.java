package com.grgbanking.fingervein.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static final SimpleDateFormat DAY_TIME = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	
	public static final SimpleDateFormat DAY = new SimpleDateFormat(
			"yyyy-MM-dd");
	
	private DateUtil() {}
	
	public static String getDayTime(Date date) {
		return DAY_TIME.format(date);
	}
	
	public static String getDay(Date date) {
		return DAY.format(date);
	}
}
