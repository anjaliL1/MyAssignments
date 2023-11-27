package week1.day1;

public class Report {

	public static void main(String[] args) {
		StudentClass s = new StudentClass();
		s.whichClass();
		//s.studentName; - cannot use the variable of other class directly, need to use it like below
		String studentName= s.studentName;
		System.out.println(studentName);
		int rollNo = s.rollNo;
		System.out.println(rollNo);
		String collegeName = s.collegeName;
		System.out.println(collegeName);
		float markScored = s.markScored;
		System.out.println(markScored);
		float cgpa = s.cgpa; 
		System.out.println(cgpa);
		/*
		 * When we create object of class1 to class2; then in order to call the variable of class1 in class2;
		 * we have to use the way defined above
		 * However, if we want to call methods of class1 to class2 by object of class1, then we can directly call
		 */
				
	}
}
