//Exercise 5: Exercise_5.java
package Eggs;

import javax.swing.JOptionPane;

public class Exercise_5 {
	public static void main(String[] args) {
		String strNum1, strNum2;
		String strNotification = "You've just enter: ";
		
		strNum1 = JOptionPane.showInputDialog(null,
				"Please input the first number: ","Input the first number",
				JOptionPane.INFORMATION_MESSAGE);
		strNotification += strNum1 + " and ";
		
		strNum2 = JOptionPane.showInputDialog(null,
				"Please input the second number: ","Input the second number",
				JOptionPane.INFORMATION_MESSAGE);
		strNotification += strNum2 + "\n";
		
		Double aDouble = Double.parseDouble(strNum1);
		Double bDouble = Double.parseDouble(strNum2);
		
		strNotification += "Sum: " + (aDouble + bDouble) + "\n";
		strNotification += "Difference: " + (aDouble - bDouble) + "\n";
		strNotification += "Product: " + (aDouble * bDouble) + "\n";
		if (bDouble == 0)
			strNotification += "0 can not be divided!";
		else {
			strNotification += "Quotient: " + (aDouble / bDouble);
		}
		
		JOptionPane.showMessageDialog(null,strNotification,
				"Calculation results", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

}
