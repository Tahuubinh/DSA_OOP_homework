package Babyfish;	//In AimsProject

import java.util.*;

import javax.swing.plaf.synth.SynthScrollBarUI;

import com.sun.org.apache.xerces.internal.impl.dv.DVFactoryException;





// To check the possibility of Order class

public class Aims {
	public static void main(String[] args) {
		//We will add these DVDs
		Order anOrder = new Order(new MyDate("February 29th 2020"));
		anOrder.getALuckyItem();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategoryString("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirectorString("Roger Allers");
		dvd1.setLength(87);
		
		System.out.print("Check search: ");
		System.out.println(dvd1.search("    Lion   The King "));
		anOrder.addDigitalVideoDisc(dvd1);
		
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategoryString("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirectorString("George Lucas");
		dvd2.setLength(124);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
		dvd3.setCategoryString("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirectorString("John Musker");
		dvd3.setLength(90);
		anOrder.addDigitalVideoDisc(dvd3);
		
		System.out.print("Lucky item: ");
		System.out.println(anOrder.getALuckyItem().getTitleString());
		
		System.out.print("Total Cost is: ");
		System.out.println(anOrder.totalCost());
		anOrder.listPrint();
		try {
			Order anOrder1 = new Order(new MyDate("February 29th 2020"));
			Order anOrder2 = new Order(new MyDate("February 29th 2020"));
			Order anOrder3 = new Order(new MyDate("February 29th 2020"));
			Order anOrder4 = new Order(new MyDate("February 29th 2020"));
			Order anOrder5 = new Order(new MyDate("February 29th 2020"));
			Order anOrder6 = new Order(new MyDate("February 29th 2020"));
			//Order anOrder7 = new Order(new MyDate("February 29th 2020"));
			
		} catch (Exception e) {
			System.out.println("Already reach the limit!");
		} 
			
		
	}
		
}

















