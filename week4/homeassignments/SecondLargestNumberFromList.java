package week4.homeassignments;

import java.util.*;

public class SecondLargestNumberFromList {

	public static void main(String[] args) {
		
		List<Integer> arry = new ArrayList<Integer>();
		arry.add(3);
		arry.add(2);
		arry.add(11);
		arry.add(4);
		arry.add(6);
		arry.add(7);
		System.out.println(arry);
		Collections.sort(arry);
		System.out.println("Sorted array is "+arry);
		System.out.println("The second largest num is: "+arry.get(4));
		
		
		

	}

}
