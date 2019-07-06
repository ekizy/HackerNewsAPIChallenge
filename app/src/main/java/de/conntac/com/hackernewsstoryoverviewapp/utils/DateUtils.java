package de.conntac.com.hackernewsstoryoverviewapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static String getDateString (long seconds) {
        Date date = new java.util.Date(seconds*1000L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.ENGLISH);
        return simpleDateFormat.format(date);
    }

}
