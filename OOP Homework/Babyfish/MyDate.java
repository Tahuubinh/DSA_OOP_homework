package Babyfish;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class MyDate{
	private int day;
	private int month;
	private int year;
	
	public MyDate() {
		super();
	}

	public MyDate(int month, int day, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public MyDate(String date){
		date = date.toLowerCase();
		List<String> myList = new ArrayList<String>(Arrays.asList(date.split(" ")));
		// Monthname in to int
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(new SimpleDateFormat("MMM").parse(myList.get(0)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int monthInt = cal.get(Calendar.MONTH) + 1;
		this.month = monthInt;
		// Remove "th" in day
		String c = myList.get(1).substring(0, myList.get(1).length() - 2);
		int d = Integer.parseInt(c);
		this.day = d;
		this.year = Integer.parseInt(myList.get(2));
		
	}
	
	public MyDate(String day, String month, String year) {
		// In order for unity, we will use American standard
		String date = month + day + year;
		date = date.toLowerCase();
		List<String> myList = new ArrayList<String>(Arrays.asList(date.split(" ")));
		// Monthname in to int
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(new SimpleDateFormat("MMM").parse(myList.get(0)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int monthInt = cal.get(Calendar.MONTH) + 1;
		this.month = monthInt;
		// Remove "th" in day
		String c = myList.get(1).substring(0, myList.get(1).length() - 2);
		int d = Integer.parseInt(c);
		this.day = d;
		this.year = Integer.parseInt(myList.get(2));
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public void accept() {	
		System.out.println("Enter your date in American standard type: ");
		try {
			Scanner sc = new Scanner(System.in);
			String date = sc.nextLine();
			
			date = date.toLowerCase();
			List<String> myList = new ArrayList<String>(Arrays.asList(date.split(" ")));
			// Monthname in to int
			Calendar cal = Calendar.getInstance();
			try {
				cal.setTime(new SimpleDateFormat("MMM").parse(myList.get(0)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int monthInt = cal.get(Calendar.MONTH) + 1;
			this.month = monthInt;
			// Remove "th" in day
			String c = myList.get(1).substring(0, myList.get(1).length() - 2);
			int d = Integer.parseInt(c);
			this.day = d;
			this.year = Integer.parseInt(myList.get(2));
			
			print();
			sc.close();
		}	catch (Exception e) {
			System.out.println("Inappropriate form!");
			System.out.println("Your date should looks like this example: \"February 18th 2019\"");
		}
	}
	
	// Notify the validation of the date
	// cannot have 2 print() method
	void print() {
		System.out.println("Your date is: ");
		System.out.println("Month: " + this.month);
		System.out.println("Day: " + this.day);
		System.out.println("Year: " + this.year);
		if (isValidDay(month, day, year))
			System.out.println("Your date is valid.");
		else {
			System.out.println("Your date is invalid!");
		}
	}
	
	// Check valid day
	
	private Boolean isLeap(int y) {
		if (y % 4 == 0) {
			if (y % 400 == 0)
				return true;
			else if (y % 100 == 0)
				return false;
			else return true;
		}
		return false;
	}
	private Boolean isValidDay(int m, int d, int y) {
		if (m < 1 || m > 12)
			return false;
		if (y < 1)
			return false;
		switch (m){
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            if (d < 1 || d > 31)
            	return false;

        case 4:
        case 6:
        case 9:
        case 11:
        	if (d < 1 || d > 30)
            	return false;

        case 2:
            if (!isLeap(y)) {
            	if (d < 1 || d > 28)
                	return false;
            }	
            else {
            	if (d < 1 || d > 29)
                	return false;
			}
        }     
		return true;
	}
}