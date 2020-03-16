package practice;

import java.util.ArrayList;
import java.util.List;

abstract class abs {
	abstract void abstractMethod();
	abs() {
		System.out.println("M hu khalnayak");
	}
	void nonAbstract() {
		System.out.println("this is the nonabstract method of abstract class");
	}
}
class A extends abs{
	int a;
	A() {
		super();
		a = 10;
		System.out.println("In class A : "+a);
	}
	void abstractMethod() {
		super.nonAbstract();
		System.out.println("This is the method of abstract class");
	}
}

class B extends A{
	int b;
	B() {
		b = 20;
		System.out.println("In class B : "+b);
	}
}
public class OOPS {

	public static void main(String[] args) {
		A b = new B();
		b.abstractMethod();
		String s1 = new String("abc");
		String s2 = s1;
		s1 = new String("bcd");
		int a = 2_2;
		System.out.println(s1);
		System.out.println(a);
		System.out.println(s2);
		Integer abc = new Integer(10);
		System.out.println(abc);
		int aabcd = abc;
		System.out.println(aabcd);
		String abs = "12345";
		System.out.println(abs.indexOf("22"));
	}

}
