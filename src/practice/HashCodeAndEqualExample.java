package practice;

import java.util.HashSet;
import java.util.Set;

class Employee {
	public int Id;
	public Employee(int id) {
		this.Id = id;
	}
	
	public int getId() {
		return this.Id;
	}
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(o == this) {
			return true;
		}
		if(o.getClass()!=this.getClass()) {
			return false;
		}
		Employee e = (Employee) o;
		
		return this.getId() == e.getId();
	}
	
	@Override
	public int hashCode() {
		int Prime = 31;
		int result = 1;
		result = Prime * result + Prime;
		return result;
	}
}

public class HashCodeAndEqualExample {

	public static void main(String[] args) {
		
		Employee e1 = new Employee(1);
		Employee e2 = new Employee(1);
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		Set<Employee> set = new HashSet<>();
		set.add(e2);
		set.add(e1);
		System.out.println(set);
		System.out.println(e1.equals(e2));
	}

}
