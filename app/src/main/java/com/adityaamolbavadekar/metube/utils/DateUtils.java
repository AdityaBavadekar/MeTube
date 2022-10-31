package com.adityaamolbavadekar.metube.utils;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static String getTimeSpanInAgo(long millis) {
        return android.text.format.DateUtils.getRelativeTimeSpanString(millis).toString();
    }

    public static String getTimeSpanInAgo(Context c, long millis) {
        return android.text.format.DateUtils.getRelativeTimeSpanString(c, millis).toString();
    }

    public static String formatTimeInAM(long millis) {
        return new SimpleDateFormat(FORMAT_TIME_IN_AM_PM, DEFAULT_LOCALE).format(new Date(millis));
    }

    public static long now() {
        return System.currentTimeMillis();
    }

    public static final String FORMAT_TIME_IN_AM_PM = "h:mm a";

    public static final Locale DEFAULT_LOCALE = Locale.ENGLISH;
}
