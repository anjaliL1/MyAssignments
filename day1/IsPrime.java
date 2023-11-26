package week1.day1;

public class IsPrime {

	public static void main(String[] args) {
		
		int num=53, flag=0;
		if(num==0 || num==1)
		{
			System.out.println(num + " num is not prime");
		}
		else
		{
			for(int i =2; i<=num/2; i++)
			{
				if(num%i==0)
				{
					System.out.println(num + " num is not prime");
					flag=1;
					break;
				}
			}
			if(flag==0) {
			System.out.println(num + " num is prime");
			}
		}

	}

}
