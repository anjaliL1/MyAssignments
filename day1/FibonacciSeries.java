package week1.day1;

public class FibonacciSeries {
	public static void main(String[] args) {
		int n1 =0, n2 = 1, n3;
		System.out.print(n1 +","+ n2); //printing 0 and 1
		
		for (int i = 1; i < 8-1; ++i) {
			n3 = n1+n2;
			System.out.print(","+n3);
			n1=n2;
			n2=n3;
			
		}
		
	}

}
