package com.example.communityapp.Utils;

import android.annotation.SuppressLint;
import android.content.res.Resources;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {

    public static long daysBetween(Date startDate, Date endDate)
    {
        long diff = endDate.getTime() - startDate.getTime();

        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    @SuppressLint("SimpleDateFormat")
    public static Date toDateStandard (String dateString) {
        try {
            return new SimpleDateFormat("dd.mm.yyyy").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    @SuppressLint("SimpleDateFormat")
    public static String standardDateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        return dateFormat.format(date);
    }
}
