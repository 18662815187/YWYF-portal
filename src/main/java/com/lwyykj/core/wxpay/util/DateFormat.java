package com.lwyykj.core.wxpay.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	public static String formatDate(String time) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date parse = sdf.parse(time);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf2.format(parse);
		return format;
	}
	
	public static Integer formatDateToInt(String time) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date parse = sdf.parse(time);
		int t = (int)(parse.getTime()/1000);
		return t;
	}
}
