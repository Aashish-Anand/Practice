package javaConcept;

abstract class Abstract1 {
	
	abstract void method1();  // this is the abstract method
}

abstract class Abstract2 extends Abstract1{
	

	abstract void method1();
//	@Override
//	public void method1() {
//		System.out.print("Override Abstract method of Class Abstract1 in Class Abstract2");
//		
//	}
	
}
class Abstract3 extends Abstract2 {

	@Override
	void method1() {
		// TODO Auto-generated method stub
		
	}
	
}

public class AbstractClasses {
	
	public static void main(String []args) {
		
		Abstract1 abs = new Abstract3();
		
	}
}
