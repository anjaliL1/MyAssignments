package week4.homeassignments;

import java.util.*;

public class FindIntersection {

	public static void main(String[] args) {
		List<Integer> firstList = new ArrayList<Integer>();//{3, 2, 11, 4, 6, 7}
		List<Integer> secList = new ArrayList<Integer>(); //{1, 2, 8, 4, 9, 7}
		firstList.add(3);
		firstList.add(2);
		firstList.add(11);
		firstList.add(6);
		firstList.add(7);
		//Collections.sort(firstList);
		System.out.println(firstList);
		secList.add(1);
		secList.add(2);
		secList.add(8);
		secList.add(4);
		secList.add(9);
		secList.add(7);
		System.out.println(secList);
		//to find the common values in list use retainAll method
		firstList.retainAll(secList);
		System.out.println("Common Elemets are:"+ firstList);

	}

}
