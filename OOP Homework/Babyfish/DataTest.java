package Babyfish;	//In AimsProject
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class DataTest {
	public static void main(String[] args) {
		System.out.println("date 1:");
		MyDate date1 = new MyDate("February 18th 2019");
		date1.print();
		
		System.out.println("date 2:");
		MyDate date2 = new MyDate(2, 29, 2002);
		date2.print();
		
		MyDate date3 = new MyDate();
		date3.setDay(14);
		date3.setMonth(3);
		date3.setYear(2021);
		System.out.println("Now we use getter in date3:");
		System.out.println("Month: " + date3.getMonth());
		System.out.println("Day: " + date3.getDay());
		System.out.println("Year: " + date3.getYear());
		try {
			DateUtils dUtils = new DateUtils();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date a = sdf.parse("2020-01-30");
	        Date b = sdf.parse("2020-01-31");
	        Date c = sdf.parse("2020-01-28");
	        Date[] array = new Date[3];
	        System.out.println("Beginning:");
	        
	        array[0] = a;
	        array[1] = b;
	        array[2] = c;
	        for (Date i: array) {
	        	System.out.println(i);
	        }
	        System.out.println("After sort: ");
	        dUtils.sortDate(array);
	        for (Date i: array) {
	        	System.out.println(i);
	        }
	        dUtils.compareDate(a, b);
		} catch (Exception e) {
			// TODO: handle exception
		}
/*		System.out.println("Check date using accept");
		MyDate date4 = new MyDate();
		date4.accept();
		*/
	}
}























