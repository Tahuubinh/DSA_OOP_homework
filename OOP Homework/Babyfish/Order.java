package Babyfish;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.swing.internal.plaf.basic.resources.basic;


public class Order{
	public static final int MAX_NUMBERS_ORDER = 10;
	private int qtyOrdered = 0;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDER];
	private MyDate dateOrdered;
	public static final int MAX_LIMITED_ORDERS = 5;
	private static int nbOrders = 0;
	
	public Order(MyDate dateOrdered) {
		super();
		if (nbOrders < MAX_LIMITED_ORDERS) {
			this.dateOrdered = dateOrdered;
			++nbOrders;
		}
		else throw new ArithmeticException("Reach limited orders already!");
	}
	//We will use qtyOrdered as an imaginary max index of itemOrdered 
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < 10) {
			itemOrdered[this.qtyOrdered] = disc;
			this.qtyOrdered++;
			System.out.println("The disc has been added");
		}
		else
			System.out.println("The order is full already");
	}
	// Overloading
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		int length = dvdList.length;
		if (length + qtyOrdered > MAX_NUMBERS_ORDER) {
			System.out.println("Overflow order! The list of items can not be added.");
		}
		else {
			for(DigitalVideoDisc disc: dvdList) {
				itemOrdered[this.qtyOrdered] = disc;
				this.qtyOrdered++;
				System.out.println("The disc has been added");
			}
			System.out.println("The list has been added.");
		}
	}
	// Overloading again
	public void addDigitalVideoDisc()
	{
		int l;
		Scanner sc = new Scanner(System.in);
		System.out.print("Number of disc: ");
		l = sc.nextInt();
		if (l + qtyOrdered > MAX_NUMBERS_ORDER) {
			System.out.println("Overflow order! The list of items can not be added.");
		}
		else {
			ArrayList<DigitalVideoDisc> order = new ArrayList<>();
			for (int i = 1; i <= l; i++) {
				System.out.println("#" + i +" disc:");
				DigitalVideoDisc disc = new DigitalVideoDisc();
				System.out.print("Title: ");
				String titleString = sc.nextLine();
				System.out.print("Category: ");
				String categoryString = sc.nextLine();
				System.out.print("Director: ");
				String directorString = sc.nextLine();
				System.out.print("Length: ");
				int length = sc.nextInt();
				System.out.print("Cost: ");
				float cost = sc.nextFloat();
				disc.setTitleString(titleString);
				disc.setCategoryString(categoryString);
				disc.setDirectorString(directorString);
				disc.setLength(length);
				disc.setCost(cost);
				order.add(disc);
				System.out.println("\n");
			}
			for (DigitalVideoDisc disc: order) {
				addDigitalVideoDisc(disc);
			}
		}
		sc.close();
	}
	// Overloading with 2 parameters
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if (2 + qtyOrdered > MAX_NUMBERS_ORDER) {
			System.out.println("Can not add all items!");
			if (qtyOrdered == MAX_NUMBERS_ORDER) {
				System.out.println("dvd1: ");
				System.out.println(dvd1.getTitleString()+"\n"+
						dvd1.getCategoryString()+"\n"+
						dvd1.getDirectorString()+"\n"+
						dvd1.getLength()+"\n"+
						dvd1.getCost()+"\n");
			}
			System.out.println("dvd2: ");
			System.out.println(dvd2.getTitleString()+"\n"+
					dvd2.getCategoryString()+"\n"+
					dvd2.getDirectorString()+"\n"+
					dvd2.getLength()+"\n"+
					dvd2.getCost()+"\n");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc  disc) {
		if (qtyOrdered > 0) {
			this.qtyOrdered--;
			System.out.println("The disc has been removed");
		}
		else 
			System.out.println("Your order is empty already");
	}

	public int getQtyOrdered() {
		return qtyOrdered;
	}
	
	//qtyOrdered should not own a setter method in order not to incur conflict with MAX_NUMBERS_ORDER
	
	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemOrdered[i].getCost();
		}
		return sum;
	}
	public void listPrint() {
		System.out.println("***********************Order***********************");
		System.out.println("Date: " + dateOrdered.getMonth() +"-" + dateOrdered.getDay() + "-" + dateOrdered.getYear());
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; ++i) {
			System.out.println((i+1)+ ". DVD - "+
							itemOrdered[i].getTitleString() + " - "+
							itemOrdered[i].getCategoryString() + " - "+
							itemOrdered[i].getDirectorString() + " - "+
							itemOrdered[i].getLength() + ": "+
							itemOrdered[i].getCost() + " $");
		}
		System.out.println("Total cost: " + totalCost() + " $");
		System.out.println("***************************************************");
	}
	 // random integer from min to max-1
	public int getRandomNumber(int min, int max) {
		int b;
		do {
			double a = (Math.random() * (max - min)) + min;
			b = (int) a;
		} while ( b == max);
		return b;
	}
	
	public DigitalVideoDisc getALuckyItem() {
		if (qtyOrdered == 0) {
			System.out.println("The order is already empty!");
			return null;
		}
		int rand = getRandomNumber(0, qtyOrdered); //0 \to qtyOrdered - 1
		// remove the lucky item
		for (int i = rand; i < qtyOrdered - 1; ++i) {
			itemOrdered[i] = itemOrdered[i+1];
		}
		qtyOrdered --;
		return itemOrdered[rand];
	}
}









