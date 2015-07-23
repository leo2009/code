
public class PolymorphismDemo {

	public static void main(String[] args) {
		Master m = new Master();
		m.feed(new Cat(), new Fish());
		m.feed(new Dog(), new Bone());
		//pro:
		//m.feed(new Pig(), new garbage()); in the future
	}

}

class Master {
	public void feed(Animal a, Food f) {
		a.cry();
		f.showName();
	}
}

abstract class Animal{
	public abstract void cry();
}

class Cat extends Animal {
	String name;
	int age;
	@Override
	public void cry() {
		System.out.println("cry...........miu");
	}
	
}

class Dog extends Animal {

	@Override
	public void cry() {
		System.out.println("cry...........woof");
	}
}

abstract class Food {
	public abstract String showName();
}

class Fish extends Food{

	@Override
	public String showName() {
		System.out.println("food...........fish");
		return null;
	}
}

class Bone extends Food {
	@Override
	public String showName() {
		System.out.println("food..........bone");
		return null;
	}
}