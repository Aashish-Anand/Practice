package javaConcept;

abstract class Abstract1 {
	
	abstract void method2();  // this is the abstract method
	void method() {

	}
}

abstract class Abstract2 extends Abstract1{
	

	abstract void method1();
	@Override
	public void method2() {
		System.out.print("Override Abstract method of Class Abstract1 in Class Abstract2");

	}
	
}
class Abstract3 extends Abstract2 {

	@Override
	void method1() {
		// TODO Auto-generated method stub
		System.out.println("method of abstract 3");
		
	}

	@Override
	void method() {
		System.out.println("aashish anand");
	}
}
interface interfaces1 {
	default void method() {
		System.out.println("aaccmds");
	}
}

public class AbstractClasses {
	
	public static void main(String []args) {
		
		Abstract1 abs = new Abstract3();
		//abs.method1();
		abs.method();
		
	}
}
