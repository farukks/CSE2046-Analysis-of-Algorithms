package Sorting;

import java.io.FileWriter;
import java.io.IOException;

public class File {
	public static void main(String[] args) {
	    try {
	      FileWriter myWriter = new FileWriter("file4.txt");
	      for(int i=1;i<=20000;i++) {
	      myWriter.write(Integer.toString(i)+"\n");
	     
	      }
	      myWriter.close();
	      System.out.println("Successfully wrote to the fxzczxcile.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }

	
	 
	}
	


