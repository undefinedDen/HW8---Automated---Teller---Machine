package app.utils;

import java.text.DecimalFormat;

public class Rounder {
    public static String getRound(double value){
        return new DecimalFormat("#.").format(value);

    }
}
