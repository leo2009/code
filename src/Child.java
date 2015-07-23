
public class Child extends Parent{
	
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	// protected and default could be accessed by child, private can't
	public int getDNA() {
		return dna;
	}
	
//	public String getDegree() {
//		return degree;
//	}
	
}

