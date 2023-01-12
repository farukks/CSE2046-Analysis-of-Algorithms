package Sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HeapSortPartial {
	public static int count=0;
	public static void main(String[] args) {
		
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\akdem\\OneDrive - marun.edu.tr\\Masaüstü/input15.txt"));
            List<Integer> lines = new ArrayList<Integer>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(Integer.parseInt(line));
            }
            br.close();
            Integer[] inputArray = lines.toArray(new Integer[lines.size()]);
            int depth = ((int) Math.log(inputArray.length))*2;
            Scanner sc=new Scanner(System.in);
            System.out.println("enter kth element:");
            int k=sc.nextInt();
            
            int n=inputArray.length;           
            HeapSortPartial.sort(inputArray, depth, 0, inputArray.length-1);   
            System.out.println("the max element is:"+inputArray[k-1]);
            for(int i=0;i<inputArray.length-k;i++) {
            
            }
            System.out.println("size of array:"+inputArray.length);
            System.out.println("count:"+count);
           
        } catch (Exception e) {
            System.out.print("File not found");
        }
        

		
	}
	

    private static void sort(Integer[] arr, int depth, int start, int end){
        int length = arr.length;
        if(length <= 1){
            return;
        }else if(depth == 0){
        	heapSort(arr, start, end);
        }else{
            if(start >= end)
                return;
            int pivot = arr[(start + end)/2];
            int index =  partition(arr, start, end, pivot);
            sort(arr, depth-1, start, index-1);
            sort(arr, depth-1, index, end);
        }
    }
   
	public static void heapSort(Integer[] arr,int start,int end)
    {
 
        // Build heap (rearrange array)
        for (int i = end / 2 - 1; i >= start; i--)
            heapify(arr, end, i);
 
        // One by one extract an element from heap
        for (int i = end - 1; i >= start; i--) {
            // Move current root to end
            int temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, start);
        }
    }
	
	
	public static void heapify(Integer[] arr, int n, int i)
    {
        int largest = i; // initialize largest as root
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 
 
        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;
 
        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
        
    }
	private static int partition(Integer[] arr, int start, int end, int pivot){
        while(start <= end){
            while(arr[start] < pivot){
                start++;
                count++;
            }
            while(arr[end] > pivot){
                end--;
                count++;
               
            }
            if(start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
           
        }
        return start;
    }

}
