package generics;

class Dimensions<T> {
	private T length;
	private T width;
	private T height;
	
	public Dimensions(T length, T width, T height) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
//	public <T> int Volume() {
//		return (int)length * (int)width * (int)height;
//	}
}
public class Main1 {

	public static void main(String[] args) {
		Dimensions d = new Dimensions(1, 2, 3);
		//System.out.println(d.Volume());
	}

}
