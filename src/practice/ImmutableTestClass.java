package practice;

import java.util.Date;

final class ImmutableClass {
	private final Integer val1;
	private final Integer val2;
	private final Date date;
	
	private ImmutableClass(Integer val1, Integer val2, Date date) {
		this.val1 = val1;
		this.val2 = val2;
		this.date = date;
	}
	
	public static ImmutableClass MutableInstantiation(Integer abc, Integer bcd, Date date) {
		val1=abc;
		return new ImmutableClass(abc, bcd, date);
	}
	
	@Override
	public String toString() {
		return val1+" - "+ val2 + " - " +date;
	}
}
public class ImmutableTestClass {

	public static void main(String[] args) {
		ImmutableClass im = ImmutableClass.MutableInstantiation(1, 2, new Date());
		System.out.println(im);
		im = ImmutableClass.MutableInstantiation(13122, 123, new Date());
		System.out.println(im);
	}

}
