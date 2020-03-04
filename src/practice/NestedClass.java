package practice;

class OuterClass {
	static int staticVar;
	int nonStatic;
	
	static {
		staticVar = 10;
		OuterClass oc = new OuterClass();
		oc.nonStatic = 20;
	}
	
	static class InnerClass {
		static int staticVarInnerClass;
		static {
			staticVarInnerClass = 30;
		}
		public static void accessOuterClass() {
			System.out.println(OuterClass.staticVar);
			System.out.println(InnerClass.staticVarInnerClass);
		}
	}
}
public class NestedClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterClass.InnerClass.accessOuterClass();

	}

}
