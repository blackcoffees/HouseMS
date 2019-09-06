package com.blackcoffees.housems.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.ndktools.javamd5.Mademd5;

public class SessionUtil {
	public static String getSessionValue(Timestamp last_login, int user_id){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = String.valueOf(user_id) + sdf.format(last_login);
		Mademd5 mademd5 = new Mademd5();
		return mademd5.toMd5(str);
	}
}
