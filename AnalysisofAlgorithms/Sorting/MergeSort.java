package Sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSort {    
	public static int count=0;
    public void mergeSort(Integer[] array, int l, int h) {
        int low = l;
        int high = h;
        if (low >= high) {
            return;
        }

        int middle = (low + high) / 2;// Find the middle point
        mergeSort(array, low, middle);// Sort first and second halves
        mergeSort(array, middle + 1, high);
        
        int Newlow = middle;//assign the middle element to new low element
        int start_high = middle + 1;//same op
        while ((low <= Newlow) && (start_high <= high)) {
            if (array[low] < array[start_high]) {
                low++;
            } 
            else {
                int Temp = array[start_high];
                for (int k = start_high - 1; k >= low; k--) {
                    array[k + 1] = array[k];
                }
                array[low] = Temp;
                low++;
                Newlow++;
                start_high++;
            }
            count++;
            
        }
    }

    public static void main(String[] args) {
        MergeSort pb = new MergeSort();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\akdem\\OneDrive - marun.edu.tr\\Masaüstü/input15.txt"));
            List<Integer> lines = new ArrayList<Integer>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(Integer.parseInt(line));
            }
            br.close();
            Integer[] inputArray = lines.toArray(new Integer[lines.size()]);
            
            pb.mergeSort(inputArray, 0, inputArray.length - 1);
          //  for (Integer i : inputArray) {//print the sorted array
          //     System.out.println(i);
          //  }
            Scanner sc=new Scanner(System.in);
            System.out.println("enter the k'th smallest element:");
            int k=sc.nextInt();          
            System.out.println("k'th smallest element:"+inputArray[k-1]);
            System.out.println("size of array:"+inputArray.length);
            System.out.println("count:"+count);
        } catch (Exception e) {
            System.out.print("File not found");
        }
        
        
    }
}