package com.accuship.demo;

public class java8InterfaceDemo {

	public static void main(String[] args) {
		new Sam().sayHello();
		//multi-inheritance
		new Sam2().sayHello();  
		new Sam2().sayBye();
		
	}

}

interface People {  
    // adds a java 8 default method  
    default void sayHello() {  
        System.out.println("Hello");  
    }  
}  
class Sam implements People {  
} 

interface Male {  
    default void sayBye() {  
        System.out.println("Bye");  
    }  
}  
class Sam2 implements People, Male {  
} 
  

