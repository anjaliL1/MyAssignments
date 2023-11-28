package week2.day2;

import java.util.Arrays;

public class FindDups {

	public static void main(String[] args) {
		
		int[] num={2, 5, 7, 7, 5, 9, 2, 3};
		System.out.println("Sorted array");
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}
		
		for (int i = 0; i < num.length; i++) {
			for (int j = i+1; j < num.length; j++) {
				if(num[i]==num[j])
				{
					System.out.println(" ");
					System.out.print(num[j]);
				}
				
			}
			
		}
		

	}

}
