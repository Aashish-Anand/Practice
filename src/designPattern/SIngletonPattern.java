package designPattern;

class Singleton {
	//private static Singleton sing = new Singleton();
	public static Singleton sing = null;
	
	private Singleton() {
		System.out.println("Private Singleton Design Pattern");
	}
	
	public static Singleton getInstance() {
		//return sing;
		
		if(sing == null) {
			return new Singleton();
		}
		return sing;
	}
}
public class SIngletonPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton s = Singleton.getInstance();
	}

}
