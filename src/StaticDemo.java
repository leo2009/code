import javax.swing.JFrame;


public class StaticDemo {

	static int i = 1;
	static {
		System.out.println("static run......");
		i++;
	}
	public StaticDemo() {
		i++;
	}
	public static void main(String[] args) {
//		StaticDemo t1 = new StaticDemo();
//		System.out.println("i is ..........." + StaticDemo.i);
//		
//		StaticDemo t2 = new StaticDemo();
//		System.out.println("i is ..........." + t1.i);
//		System.out.println("i is ..........." + StaticDemo.i);
		
	}

}

class Student{
	String name;
	static int totalFee;
	public Student(String name, int fee) {
		this.name= name;
		totalFee += fee;
	}
	
	private static int getTotalFee() {
		return totalFee;
	}
}


