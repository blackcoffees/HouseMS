package com.blackcoffees.housems.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Timestamp getNow(){
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String date = sdf.format(new Date());
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		return Timestamp.valueOf(date);
	}
}
