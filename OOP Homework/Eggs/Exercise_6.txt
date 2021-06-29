//Exercise 6: Exercise_6.java
package Eggs;

import javax.swing.JOptionPane;

public class Exercise_6 {
	public static void main(String[] args) {
		String strNotificationString = "Solving Equations: ";
		String aString;
		String bString;
		String cString;
		String selectionString;

		// Choose problem 1, 2 or 3
		selectionString = JOptionPane.showInputDialog(null,
				"Choose one of these kinds of solution to solve:\n"
						+ "1: The first degree equation (linear equation) with one variable\n"
						+ "2: The first degree equation (linear equation) with two variables\n"
						+ "3: The second degree equation with one variable\n" + "Enter your choice (e.g 1): ",
				"Option Box", JOptionPane.INFORMATION_MESSAGE);
		Double selectionDouble = Double.parseDouble(selectionString);

		// The first degree equation (linear equation) with one variable
		if (selectionDouble == 1) {
			aString = JOptionPane.showInputDialog(null, "Please input a: ", "ax + b = 0",
					JOptionPane.INFORMATION_MESSAGE);
			bString = JOptionPane.showInputDialog(null, "Please input b: ", "ax + b = 0",
					JOptionPane.INFORMATION_MESSAGE);
			strNotificationString += aString + "x + " + bString + " = 0.\n";
			double a = Double.parseDouble(aString);
			double b = Double.parseDouble(bString);
			if (a == 0) {
				if (b == 0)
					strNotificationString += "Infinite solutions!";
				else {
					strNotificationString += "No solution!";
				}
			} else {
				strNotificationString += "x = " + (-b / a);
			}
			JOptionPane.showMessageDialog(null, strNotificationString, "Result", JOptionPane.INFORMATION_MESSAGE);
		}

		// The first degree equation (linear equation) with two variables
		else if (selectionDouble == 2) {
			aString = JOptionPane.showInputDialog(null, "Please input a: ", "ax + by = c",
					JOptionPane.INFORMATION_MESSAGE);
			bString = JOptionPane.showInputDialog(null, "Please input b: ", "ax + by = c",
					JOptionPane.INFORMATION_MESSAGE);
			cString = JOptionPane.showInputDialog(null, "Please input c: ", "ax + by = c",
					JOptionPane.INFORMATION_MESSAGE);
			strNotificationString += aString + "x + " + bString + "y = " + cString + ".\n";
			double a = Double.parseDouble(aString);
			double b = Double.parseDouble(bString);
			double c = Double.parseDouble(cString);
			if (a == 0) {
				if (b == 0) {
					if (c == 0)
						strNotificationString += "x and y can be of any real number";
					else
						strNotificationString += "No solution!";
				} else {
					strNotificationString += "x can be of any real number\n";
					strNotificationString += "y = " + (c / b);
				}
			} else {
				strNotificationString += "x = " + (c / a) + " - " + (b / a) + "y \n";
				strNotificationString += "y can be of any real number";
			}
			JOptionPane.showMessageDialog(null, strNotificationString, "Result", JOptionPane.INFORMATION_MESSAGE);
		}

		// The second degree equation with one variable
		else if (selectionDouble == 3) {
			aString = JOptionPane.showInputDialog(null, "Please input a: ", "ax^2 +bx +c = 0",
					JOptionPane.INFORMATION_MESSAGE);
			bString = JOptionPane.showInputDialog(null, "Please input b: ", "ax^2 +bx +c = 0",
					JOptionPane.INFORMATION_MESSAGE);
			cString = JOptionPane.showInputDialog(null, "Please input c: ", "ax^2 +bx +c = 0",
					JOptionPane.INFORMATION_MESSAGE);
			strNotificationString += aString + "x^2 + " + bString + "x + " + cString + " = 0.\n";
			double a = Double.parseDouble(aString);
			double b = Double.parseDouble(bString);
			double c = Double.parseDouble(cString);
			if (a == 0) {
				if (b == 0) {
					if (c == 0)
						strNotificationString += "Infinite solutions!";
					else {
						strNotificationString += "No solution!";
					}
				} else {
					strNotificationString += "x = " + (-c / b);
				}
			} else {
				double delta = b * b - 4 * a * c;
				if (delta < 0)
					strNotificationString += "No solution!";
				else if (delta == 0) {
					strNotificationString += "Double root x = " + (-b / 2 / a);
				} else {
					double d = Math.sqrt(delta);
					strNotificationString += "Two solution:\n";
					strNotificationString += "x1 = " + ((-b - d) / 2 / a) + "\n";
					strNotificationString += "x2 = " + ((-b + d) / 2 / a);
				}
			}
			JOptionPane.showMessageDialog(null, strNotificationString, "Result", JOptionPane.INFORMATION_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "There's no such option, try again!", "Response",
					JOptionPane.INFORMATION_MESSAGE);
	}
}
