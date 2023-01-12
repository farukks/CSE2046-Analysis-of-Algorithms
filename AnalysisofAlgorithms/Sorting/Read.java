package Sorting;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Read {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int data[]=readFiles("C:\\Users\\akdem\\OneDrive - marun.edu.tr\\Masaüstü/input.txt");
			System.out.println(Arrays.toString(data));
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

}
