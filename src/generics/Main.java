package generics;

class Test<T> {
	
	T obj;
	
	Test(T obj) {
		this.obj = obj;
	}
	
	public T getObj() {
		return this.obj;
	}
}

public class Main {

	public static void main(String[] args) {
		
		Test<Integer> t = new Test<>(4);
		System.out.println(t.getObj());
		
		Test<String> str = new Test<>("Abc");
		System.out.println(str.getObj());
	}

}
