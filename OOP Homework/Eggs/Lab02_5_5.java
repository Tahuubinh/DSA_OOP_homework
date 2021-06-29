package Eggs;
import java.util.Scanner;

public class Lab02_5_5 {
	//check leap year
	static Boolean isLeap(int y) {
		if (y % 4 == 0) {
			if (y % 400 == 0)
				return true;
			else if (y % 100 == 0)
				return false;
			else return true;
		}
		return false;
	}
	//Display answer
	static void number_of_day(int m, int y) {
		switch (m){
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            System.out.println("This month has 31 days"); 
            break;

        case 4:
        case 6:
        case 9:
        case 11:
            System.out.println("This month has 31 days"); 
            break;

        case 2:
            if (isLeap(y))
            	System.out.println("This month has 29 days");
            else {
            	System.out.println("This month has 28 days");
			}
        }     
	}
	
	public static void main(String[] args) {
		//input information
		Scanner sc = new Scanner(System.in);
		int m;
		int y;
		String month;
		
		do {
			System.out.println("Month: ");
			month = sc.next();
			System.out.println("Year: ");
			y = sc.nextInt();	
			
			switch(month) {
			case "January":
			case "Jan":
			case "Jan.":
			case "1":
				m = 1;
				break;
			case "February":
			case "Feb":
			case "Feb.":
			case "2":
				m = 2;
				break;
			case "March":
			case "Mar":
			case "Mar.":
			case "3":
				m = 3;
				break;
			case "April":
			case "Apr":
			case "Apr.":
			case "4":
				m = 4;
				break;
			case "May":
			case "May.":
			case "5":
				m = 5;
				break;
			case "June":
			case "Jun":
			case "Jun.":
			case "6":
				m = 6;
				break;
			case "July":
			case "Jul":
			case "Jul.":
			case "7":
				m = 7;
				break;
			case "August":
			case "Aug":
			case "Aug.":
			case "8":
				m = 8;
				break;
			case "September":
			case "Sep":
			case "Sep.":
			case "9":
				m = 9;
				break;
			case "October":
			case "Oct":
			case "Oct.":
			case "10":
				m = 10;
				break;
			case "November":
			case "Nov":
			case "Nov.":
			case "11":
				m = 11;
				break;
			case "December":
			case "Dec":
			case "Dec.":
			case "12":
				m = 12;
				break;
			default:
				m = -1;
			
			}
		} while(m < 1 || m > 12 || y < 0);
		number_of_day(m, y);
		sc.close();
	}
}
