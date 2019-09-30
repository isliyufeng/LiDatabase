package com.lyf.utils;

import java.text.DecimalFormat;

/**
 * @author 喜闻乐见i
 */
public class StringUtils {

    public static String getStrTime(int time){
        // 7146   02:00:00
        StringBuilder sb =new StringBuilder();
        int hour = time / 3600;
        DecimalFormat df = new DecimalFormat("00");
        sb.append(df.format(hour)+":");
        int temp = time % 3600;
        int minute = temp / 60 ;
        sb.append(df.format(minute)+":");
        int second = temp % 60;
        sb.append(df.format(second));
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(getStrTime(7260));
    }
}
