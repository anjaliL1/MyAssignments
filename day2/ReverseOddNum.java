package week2.day2;

public class ReverseOddNum {

	public static void main(String[] args) {
		String test = "I am a software tester";
		String[] s = test.split(" "); //split the test into array elements
		for (int i = 0; i < s.length; i++) { //for loop is to check for odd numbers
			if(i%2!=0) //condition to verify odd num
			{
				char[] ch = s[i].toCharArray(); //reversing each odd position array elements
				for (int j = ch.length-1; j >=0 ; j--)
				{
					System.out.print(ch[j]);
					
				}
				
			}
			else
			{
				System.out.print(" "+s[i]+" ");
		    }
		}

	}
		
}
