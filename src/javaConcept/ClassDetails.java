package javaConcept;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Student {
	String name;
	int rollNo;
	
	Student(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Integer getrollNo() {
		return this.rollNo;
	}
	
	public void printAllDetails() {
		System.out.println(this.name + " " + this.rollNo);
	}
}
public class ClassDetails {

	public static void main(String[] args) {
		
		Student s = new Student("aashish", 4);
		
		Class c = s.getClass();
		
		System.out.println(c.getName());
		
		Method method[] = c.getDeclaredMethods();
		
		for (Method method2 : method) {
			System.out.println(method2.getName());
		}
		
		Field f[] = c.getDeclaredFields();
		
		for (Field field : f) {
			System.out.println(field.getName());
		}
		
	}

}
