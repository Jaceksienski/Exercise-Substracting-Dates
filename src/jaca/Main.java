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

        class MyDate {
            private boolean isStringPm;
            private final ArrayList<Integer> splitDateInt = new ArrayList<>();

            MyDate(String date) {
                if (date.contains("pm")) isStringPm = true;
                String dateWithoutAmPm = date.substring(0, date.length() - 2);
                ArrayList<String> splitDate = new ArrayList<>();
                splitDate.addAll(List.of(dateWithoutAmPm.split(":")));
                for (String s : splitDate) {
                    splitDateInt.add(Integer.valueOf(s));
                }
                if (isStringPm) {
                    splitDateInt.set(0, splitDateInt.get(0) + 12);
                    if (splitDateInt.get(0) == 24) splitDateInt.set(0, 0);
                }
            }
            LocalTime getDataAsLocalTime() {
                return LocalTime.of(splitDateInt.get(0),splitDateInt.get(1));
            }
        }

        String[] splitStr = str.split("-");
        MyDate date1 = new MyDate(splitStr[0]);
        MyDate date2 = new MyDate(splitStr[1]);

        str = String.valueOf(MINUTES.between(
                date1.getDataAsLocalTime(),
                date2.getDataAsLocalTime()));

        return str;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(StringChallenge(s.nextLine()));
    }
}
