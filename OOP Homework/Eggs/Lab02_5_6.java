package Eggs;

import java.util.Scanner;

import jdk.javadoc.internal.doclets.toolkit.taglets.SummaryTaglet;

import java.util.ArrayList;
import java.util.Arrays;

public class Lab02_5_6 {
	//Using merge sort
	void merge(ArrayList<Double> arr, int p, int q, int r) {

		int n1 = q - p + 1;
	    int n2 = r - q;

	    double L[] = new double[n1];
	    double M[] = new double[n2];

	    for (int i = 0; i < n1; i++)
	    	L[i] = arr.get(p + i);
	    for (int j = 0; j < n2; j++)
	    	M[j] = arr.get(q + 1 + j);

	    int i, j, k;
	    i = 0;
	    j = 0;
	    k = p;
	    
	    while (i < n1 && j < n2) {
	    	if (L[i] <= M[j]) {
	        arr.set(k, L[i]);
	        i++;
	    	} else {
	    		arr.set(k, M[j]);
	        j++;
	    	}
	    	k++;
	    }

	    while (i < n1) {
	    	arr.set(k, L[i]);
	    	i++;
	    	k++;
	    }

	    while (j < n2) {
	    	arr.set(k, M[j]);
	    	j++;
	    	k++;
	    }
	}

	void mergeSort(ArrayList<Double> arr, int l, int r) {
		if (l < r) {

	    int m = (l + r) / 2;

	    mergeSort(arr, l, m);
	    mergeSort(arr, m + 1, r);

	    merge(arr, l, m, r);
	    }
	}

	//average and print function
	static void printArray(ArrayList<Double> arr) {
		System.out.print("After sort: ");
		for (double i : arr) {
			System.out.print(i + " ");
		}
	}
	
	static void average(ArrayList<Double> arr) {
		double sum = 0;
		int length = arr.size();
		for (double i : arr) {
			sum += i;
		}
		System.out.println("Average = " + (sum / length));
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Double> arr = new ArrayList<Double>();
		
		System.out.println("Length of array: ");
		int length = sc.nextInt();
		
		for (int i = 0; i < length; ++i) {
			double m = sc.nextDouble();
			arr.add(m);
		}
		//create new object to use mergeSort without static
		Lab02_5_6 ob = new Lab02_5_6();
		ob.mergeSort(arr, 0, length - 1);
		
		average(arr);
		printArray(arr);
		sc.close();
	}
}











