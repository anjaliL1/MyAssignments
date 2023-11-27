package week1.day1;

public class Mobile {
	
	public void makeCall()
	{
		String mobileModel="Sam";
		float mobileWeight=110.5f;
		System.out.println("You are making a call now");
	}
	public void sendMsg()
	{
		boolean isFullChanrge = true;
		int mobileCost = 15000;
		System.out.println("Send a msg to your dear ones");
	}
	
	public static void main(String[] args) {
		Mobile m = new Mobile();
		m.makeCall();
		m.sendMsg();
		//I am unable to print the variable using object reference
		System.out.println(m.mo);
		System.out.println("This is my mobile num");
	}

}
