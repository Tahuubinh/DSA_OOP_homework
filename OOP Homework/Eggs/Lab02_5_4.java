package Eggs;
import java.util.Scanner;

public class Lab02_5_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++)
				System.out.print(" ");
			for (int j = n-i; j <= n+i; ++j)
				System.out.print("*");
			System.out.println();
		}
		sc.close();
	}
}
