package com.destructo.corona_tracker.View.Adapter;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {



    public static String formatNumber(int number){
        return NumberFormat.getNumberInstance(Locale.US).format(number);
    }

    public static String formatNumber(long number){
        return NumberFormat.getNumberInstance(Locale.US).format(number);
    }

    public static String formatNumber(double number){
        return NumberFormat.getNumberInstance(Locale.US).format(number);
    }

    public static String formatDate(long date){
        Date update = new Date(date);
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss a",Locale.getDefault());
        return sm.format(update);
    }
}
