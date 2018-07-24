package com.example.domain.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateFormatUtils {

    private static final String DATE_PATTERN = "dd.MM.yyyy.";
    private static final SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat(DATE_PATTERN, Locale.getDefault());

    public static SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }
}
