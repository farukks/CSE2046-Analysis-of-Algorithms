package Sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectionSortPartial {
	public static int count=0;
	public static void main(String[] args) {
		
		try {
			BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\akdem\\OneDrive - marun.edu.tr\\Masaüstü/input11.txt"));
			List<Integer> lines=new ArrayList<Integer>();
			String line;
			while((line=br.readLine())!=null) {
				lines.add(Integer.parseInt(line));
			}
			br.close();
			
			Integer[] arr=lines.toArray(new Integer[lines.size()]);
			
			Scanner scan=new Scanner(System.in);
            System.out.println("enter the k'th smallest element:");
            int k=scan.nextInt();
            
			SelectionSortPartial.selectionSort(arr,arr.length,k);
			//for(Integer i:arr) {
			//	System.out.println(i);
			//}
			System.out.println("k'th smallest element:"+arr[k-1]);
			System.out.println("count:"+count);
			System.out.println("size of array:"+arr.length);
		
		}
		catch(Exception e){
			System.out.println("File not found");
			
		}
		
	}
	
	public static void selectionSort(Integer[] array,int arraySize,int kthSmallestElement) {
		
		
		int temp;
	    for (int i = 0; i < kthSmallestElement; i++)	 {
	    	int min = i;
	        for (int j = i+1; j < arraySize; j++) 
	            if (array[j] < array[min]) min = j;
	        temp = array[min];
	        for (int j = min; j > i; j--) 
	            array[j] = array[j-1];
	        array[i] = temp;
	        count++;
	      } 
	}

}
