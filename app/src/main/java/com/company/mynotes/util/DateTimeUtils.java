package com.company.mynotes.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class DateTimeUtils {

    private DateTimeUtils() {
    }

    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.ENGLISH);

    public static String getStringTime(Date date) {
        return dateFormat.format(date);
    }
}
