package Eggs;
import java.util.Scanner;

public class Lab02_5_7 {
	
	static double[][] addMatrix(double[][] a, double[][] b, int m, int n){
		double[][] c = new double[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		return c;
	}
	
	static void matrixDisplay(double[][] c) {
		for (double[] i:c) {
			for (double j: i)
				System.out.print(j + "\t");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m;
		int n;
		//input legal m and n
		do {
			System.out.println("Input integer m > 0: ");
			m = sc.nextInt();
		}	while (m < 1);		
		do {
			System.out.println("Input integer n > 0: ");
			n = sc.nextInt();
		}	while (n < 1);
		//input two matrices
		double[][] a = new double[m][n];
		double[][] b = new double[m][n];
		
		System.out.println("Input matrix a: ");
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				System.out.println("a[" + i +"][" + j +"] = ");
				a[i][j] = sc.nextDouble();
			}
		System.out.println("Input matrix b: ");
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				System.out.println("b[" + i +"][" + j +"] = ");
				b[i][j] = sc.nextDouble();
			}
		
		double[][] c = addMatrix(a, b, m, n);
		
		// Display result
		System.out.println("Matrix a: ");
		matrixDisplay(a);
		System.out.println("Matrix b: ");
		matrixDisplay(b);
		System.out.println("Sum: ");
		matrixDisplay(c);
		
		sc.close();
		
	}

}





