package week3.day2;

public class Elements extends Button {
	public static void main(String[] args) {
		
		System.out.println("This is for Button class output");
		Button b = new Button();
		b.click();
		b.setText("Anjali is great");
		b.submit();
		System.out.println("----------------------------------------------------");
		
		System.out.println("This is for TextField class output");		
		TextField tf = new TextField();
		tf.click();
		tf.getText();
		tf.setText("Preyanshu is Great");
		System.out.println("----------------------------------------------------");
		
		System.out.println("This is for CheckBoxButton class output");		
		CheckBoxButton chk = new CheckBoxButton();
		chk.click();
		chk.clickCheckButton();
		chk.setText("Namya is Great");
		chk.submit();
		System.out.println("----------------------------------------------------");
		
		System.out.println("This is for RadioButton class output");	
		RadioButton rb = new RadioButton();
		rb.click();
		rb.selectRadioButton();
		rb.setText("Our Master is Gurudev");
		rb.submit();
		
		
	}

}
