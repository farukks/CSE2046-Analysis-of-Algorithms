package Sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
	public static int count=0;
	
	public static void main(String[] args) {
		//read input file
		int data[]=readFiles("C:\\Users\\akdem\\OneDrive - marun.edu.tr\\Masaüstü/input9.txt");
		insertionSort(data);//sorting array using insertion sort    
	   // for(int member:data){    
	    //  System.out.print(member +"\n");  //prints out each element of the array
	   // }
	    //getting input from user
	    System.out.println("please enter kth smallest element :");
	    Scanner scan=new Scanner(System.in);
	    Integer k=scan.nextInt();
	    System.out.println("k’th smallest element:"+data[k-1]);//k’th smallest element
	    System.out.println("count:"+count);//number of basic operation's executions
	    System.out.println("array size:"+data.length);
}
		private static int[] readFiles(String file) {
			try {
				File f=new File(file);
				Scanner s=new Scanner(f);
				int ctr=0;
				while(s.hasNextInt()) {
					ctr++;
					s.nextInt();
				}
				s.close();
				int [] arr=new int[ctr];
				Scanner s1=new Scanner(f);
				for(int i=0;i<arr.length;i++)
					arr[i]=s1.nextInt();
				return arr;
				
			}
			catch(Exception e) {
				return null;				
			}
			
	}		
		public static void insertionSort(int array[]) {
		int n=array.length;
		for(int i=1;i<n;i++) {
			int number=array[i];
			int j=i-1;
			 /* Move elements of array, that are greater than key, to one position ahead
                of their current position */
			for(;(j>=0 && array[j]>number);j--) {
					array[j+1]=array[j];
					count++;
			}
				array[j+1]=number;
			
			}						
		}		
	}


