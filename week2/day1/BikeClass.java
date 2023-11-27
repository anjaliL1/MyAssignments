package week1.day1;


public class BikeClass extends Car{
 public static void main(String[] args) {
	 Car c = new Car();
	 System.out.println("This is for class Car");
	 c.applyBreak();
	 c.soundHorn();
	 BikeClass b = new BikeClass();
	 System.out.println("This is for class Bike");
	 b.applyBreak();
	 b.soundHorn();
	
}
}
