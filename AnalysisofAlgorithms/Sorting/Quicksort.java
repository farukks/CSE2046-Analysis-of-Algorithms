package Sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Quicksort {
	public static int count=0;
		  public static void main(String args[]) {
			  Quicksort pb = new Quicksort();
		        try {
		            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\akdem\\OneDrive - marun.edu.tr\\Masaüstü/input.txt"));
		            List<Integer> lines = new ArrayList<Integer>();
		            String line;
		            while ((line = br.readLine()) != null) {
		                lines.add(Integer.parseInt(line));
		            }
		            br.close();
		            Integer[] inputArray = lines.toArray(new Integer[lines.size()]);
		            
		            Quicksort.quickSort(inputArray, 0, inputArray.length-1);
		            //for (Integer i : inputArray) {
		            //    System.out.println(i);
		           // }
		            Scanner sc=new Scanner(System.in);
		            System.out.println("enter the k'th smallest element:");
		            int k=sc.nextInt();          
		            System.out.println("k'th smallest element:"+inputArray[k]);
		            System.out.println("size of array:"+inputArray.length);
		        } catch (Exception e) {
		            System.out.print("File not found");
		        }
		        System.out.println("count:"+count);
		        
		  }
		

  // method to find the partition position
   static int partition(Integer[] array, int low, int high) {
	   // choose the leftmost element as pivot
	   int pivot=array[low],p1=low+1,temp;

	   	// traverse through all elements
	    // compare each element with pivot
	   for(int i=low+1;i<=high;i++)
	   {

	   if(array[i]<pivot)
	       {
	           if(i!=p1)
	         {  
	               temp=array[p1];
	               array[p1]=array[i];
	               array[i]=temp;
	         }    p1++;
	       }
	   count++;
	   }

	           array[low]=array[p1-1];
	           array[p1-1]=pivot;

	   return p1-1;
    
  }

  static void quickSort(Integer array[], int low, int high) {
    if (low < high) {

      // find pivot element such that
      // elements smaller than pivot are on the left
      // elements greater than pivot are on the right
      int pi = partition(array, low, high);
      
      // recursive call on the left of pivot
      quickSort(array, low, pi - 1);

      // recursive call on the right of pivot
      quickSort(array, pi + 1, high);
    }
  }
}



