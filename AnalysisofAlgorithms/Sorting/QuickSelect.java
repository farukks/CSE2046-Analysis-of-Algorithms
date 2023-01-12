package Sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSelect {
 public static int count=0;
   static int partition(Integer[] array, int low,int high)
    {
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
	               
	         }	
	           p1++;
	       }
	   count++;
	   }
	   		
	           array[low]=array[p1-1];
	           array[p1-1]=pivot;

	   return p1-1;
	   /*
        int pivot = arr[high], pivotloc = low;
        for (int i = low; i <= high; i++) {
            // inserting elements of less value
            // to the left of the pivot location
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[pivotloc];
                arr[pivotloc] = temp;
                pivotloc++;
            }
        }
 
        // swapping pivot to the final pivot location
        int temp = arr[high];
        arr[high] = arr[pivotloc];
        arr[pivotloc] = temp;
 
        return pivotloc;
        */
    }
 
    static int kthSmallest(Integer[] arr, int low,
                                  int high,int k)
    {
    	
    	// find the partition
        int partition = partition(arr, low, high);
 
        // if partition value is equal to the kth position,
        // return value at k.
        if (partition == k -1)
            return arr[partition];
 
        // if partition value is less than kth position,
        // search right side of the array.
        else if (partition < k-1 )
            return kthSmallest(arr, partition + 1, high, k);
 
        // if partition value is more than kth position,
        // search left side of the array.
        else
            return kthSmallest(arr, low, partition - 1, k);
    
    }
    public static void main(String[] args)
    {
    	        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\akdem\\OneDrive - marun.edu.tr\\Masaüstü/input15.txt"));
            List<Integer> lines = new ArrayList<Integer>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(Integer.parseInt(line));
            }
            br.close();
            Integer[] inputArray = lines.toArray(new Integer[lines.size()]);
            Scanner sc=new Scanner(System.in);
            System.out.println("enter the k'th smallest element:");
            int k=sc.nextInt();  
           QuickSelect.kthSmallest(inputArray, 0, inputArray.length - 1,k);
           // for (Integer i : inputArray) {
           //     System.out.println(i);
          //  }
            System.out.println("kth smallest element:"+inputArray[k-1]);
            System.out.println("count:"+count);
            System.out.println("size of array:"+inputArray.length);
            
        } catch (Exception e) {
            System.out.print("File not found");
        }
        //System.out.println(count);
        
    }
    }

