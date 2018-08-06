package com.xc.mybook.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Timestamp getSqlTimeStamp(){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }

    public static String getYear(){
        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    }

    public static String getMonth(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.MONTH)+1);
    }

    public static String getDay(){
        return String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
    }

    public static String getYYYYMMDD(){
        StringBuilder sb = new StringBuilder();
        sb.append(getYear()).append(getMonth()).append(getDay());
        return sb.toString();
    }

    public static String getYYYYDOTMMDOTDD(){
        StringBuilder sb = new StringBuilder();
        sb.append(getYear());
        sb.append(".");
        sb.append(getMonth());
        sb.append(".");
        sb.append(getDay());
        return sb.toString();
    }
}
