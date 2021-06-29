package hust.soict.aims;

import java.util.Random;

public class NoGarbage {
	public static void main(String[] args) { 
		Random random = new Random(123);
		String s ="abc";
		for(int i = 1; i < 100; ++i) {
			for (int j = 0; j < 111; ++j) {
				System.gc();
				s = "a" + i;
				
			}
		}
		System.out.println(s);
	}
}
