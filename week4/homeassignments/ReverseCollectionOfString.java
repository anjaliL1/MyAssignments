package week4.homeassignments;

import java.util.*;

public class ReverseCollectionOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//created String collection to store the data
		List<String> array = new ArrayList<String>();
		//another list to keep sorted data
		List<String> arrayNew = new ArrayList<String>();
		array.add("HCL");
		array.add("Wipro");
		array.add("Aspire Systems");
		array.add("CTS");
		//print the array list
		System.out.println(array);
		//sort the array list
		Collections.sort(array);
		//print the sorted list
		System.out.println(array);
		//to print the reverse of the String list, use for loop, store the value in String variable and then add that variable to the new list(arrayNew)
		for (int i = array.size()-1; i>=0; --i) {
			String val = array.get(i);
			arrayNew.add(val);
			
		}
		//Print the reverse of the list
		System.out.println(arrayNew);
	}

}
