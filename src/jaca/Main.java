package jaca;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.MINUTES;

//input:    12:30pm-12:00am
//output:   690

public class Main {

    public static String StringChallenge(String str) {

        String[] datesWithAmPm = str.split("-");
        boolean[] isPm = new boolean[2];

        if (datesWithAmPm[0].contains("pm")) isPm[0] = true;
        if (datesWithAmPm[1].contains("pm")) isPm[1] = true;

        datesWithAmPm[0] = datesWithAmPm[0].substring(0, datesWithAmPm[0].length() - 2);
        datesWithAmPm[1] = datesWithAmPm[1].substring(0, datesWithAmPm[1].length() - 2);

        ArrayList<String> dates = new ArrayList();
        ArrayList<Integer> datesInt = new ArrayList();
        dates.addAll(List.of(datesWithAmPm[0].split(":")));
        dates.addAll(List.of(datesWithAmPm[1].split(":")));

        for (String s:
             dates) {
            datesInt.add(Integer.valueOf(s));
        }
        if(isPm[0]) {
            datesInt.set(0, datesInt.get(0) + 12);
            if (datesInt.get(0) == 24) datesInt.set(0,0);
        }
        if(isPm[1]) {
            datesInt.set(2, datesInt.get(2)+12);
            if (datesInt.get(2) == 24) datesInt.set(2,0);
        }

        LocalTime time1 = LocalTime.of(datesInt.get(0),datesInt.get(1));
        LocalTime time2 = LocalTime.of(datesInt.get(2),datesInt.get(3));

        str = String.valueOf(MINUTES.between(time1, time2));

        return str;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(StringChallenge(s.nextLine()));
    }
}
