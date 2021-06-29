package Babyfish;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jdk.internal.jshell.tool.resources.l10n;

public class DateUtils {
	void compareDate(Date a, Date b) {
		int result = a.compareTo(b);
		if (result == 0) {
            System.out.println(a + " is equal to" + b);
        } else if (result > 0) {
            System.out.println(a + " is after " + b);
        } else if (result < 0) {
            System.out.println(a + " is before " + b);
        } else {
            System.out.println("Invalid date!");
        }
	}
	void sortDate(Date[] arr) {
		int l = arr.length;
		for (int i = 0; i < l-1; ++i)
			for (int j = i + 1; j < l; ++j) {
				if (arr[i].compareTo(arr[j]) > 0) {
					Date tempDate = arr[i];
					arr[i] = arr[j];
					arr[j] = tempDate;
				}
			}
	}
	
	// This main is just another way to campare two date
    /*public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2020-01-30");
        Date date2 = sdf.parse("2020-01-31");

        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        int result = date1.compareTo(date2);
        System.out.println("result: " + result);

        if (result == 0) {
            System.out.println("Date1 is equal to Date2");
        } else if (result > 0) {
            System.out.println("Date1 is after Date2");
        } else if (result < 0) {
            System.out.println("Date1 is before Date2");
        } else {
            System.out.println("How to get here?");
        }

    }*/
}
