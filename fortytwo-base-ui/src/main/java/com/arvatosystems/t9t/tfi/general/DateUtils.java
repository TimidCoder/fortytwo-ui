package com.arvatosystems.t9t.tfi.general;

import java.text.SimpleDateFormat;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import com.arvatosystems.t9t.tfi.web.ZulUtils;

public class DateUtils {
    private static SimpleDateFormat dateFormat;
    private static SimpleDateFormat dateTimeFormat;

    public static final String getDate(LocalDate date) {
        return getDateFormat().format(date.toDate());
    }

    public static final String getDateTime(LocalDateTime dateTime) {
        return getDateTimeFormat().format(dateTime.toDate());
    }

    private static SimpleDateFormat getDateFormat() {
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat(ZulUtils.i18nLabel("com.date.format"));
        }
        return dateFormat;
    }

    private static SimpleDateFormat getDateTimeFormat() {
        if (dateTimeFormat == null) {
            dateTimeFormat = new SimpleDateFormat(ZulUtils.i18nLabel("com.datetime.format"));
        }
        return dateTimeFormat;
    }
}
