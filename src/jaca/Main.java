package jaca;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Scanner;

//12:30pm-12:00am

public class Main {

    public static String StringChallenge(String str) {

        Date date = new Date();
        System.out.println(date.getTime());

        String date1Hours = str.substring(0, 2);
        String date1Minutes = str.substring(3, 5);
        String date1AmOrPm = str.substring(5, 6);

        boolean isMoved = false;
        try {
            Double.parseDouble(date1Hours);
        } catch(NumberFormatException e){
            date1Hours = str.substring(0, 1);
            date1Minutes = str.substring(2, 4);
            date1AmOrPm = str.substring(4, 5);
        }

        int date1minInt = Integer.parseInt(date1Minutes);
        boolean isDate1Am = date1AmOrPm.equals("a");

        int date1H = Integer.parseInt(date1Hours);
        if (!isDate1Am) date1H = date1H +12;


        String date2Hours = str.substring(8, 10);
        String date2Minutes = str.substring(11, 13);
        String date2AmOrPm = str.substring(13, 14);
        if(isMoved){
            date2Hours = str.substring(7, 9);
            date2Minutes = str.substring(10, 12);
            date2AmOrPm = str.substring(12, 13);

        }
        try {
            Double.parseDouble(date1Hours);
        } catch(NumberFormatException e){
            date2Hours = str.substring(8, 9);
            date2Minutes = str.substring(10, 12);
            date2AmOrPm = str.substring(12, 13);
            if(isMoved){
                date2Hours = str.substring(7, 8);
                date2Minutes = str.substring(9, 11);
                date2AmOrPm = str.substring(11, 12);

            }
        }
        if(isMoved){


        }
        int date2minInt = Integer.parseInt(date2Minutes);

        boolean isDate2Am = date2AmOrPm.equals("a");

        int date2H = Integer.parseInt(date2Hours);
        if (!isDate2Am) date2H = date2H +12;


        int result = (date1H - date2H) *60;
        result = result - date1minInt - date2minInt;


        str = String.valueOf(result);

        return str;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(StringChallenge(s.nextLine()));
    }
}
