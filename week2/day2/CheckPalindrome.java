package week2.day2;

public class CheckPalindrome {
	
	public void checkPal(String s)
	{
		String p = s;
		String rev="";
		System.out.print(p+" | ");
		for (int i = p.length()-1; i>=0; i--) {
			rev = rev+ p.charAt(i);		
			//System.out.println(rev);
		}System.out.println(rev);
		if(p.equalsIgnoreCase(rev)) {
			System.out.println("It's a palindrome");
		}else {
			System.out.println("It's not a plaindrome");
		}
		
	}
	public static void main(String[] args) {
		
		CheckPalindrome c1 = new CheckPalindrome();
		CheckPalindrome c2 = new CheckPalindrome();
		c1.checkPal("Anjali");
		System.out.println("----------------------");
		c2.checkPal("RaceCaR");
		
	}

}
