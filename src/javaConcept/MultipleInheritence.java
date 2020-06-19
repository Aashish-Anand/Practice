package javaConcept;

interface MyInterface1 {
    public static int num = 40;
    default void display() {
        System.out.println(num);
    }
}

interface MyInterface2 {
    public static int num1 = 100;
    default void display() {
        System.out.println(num1);
    }
}

public class MultipleInheritence implements MyInterface1, MyInterface2{
    public static void main(String[] args) {
        MultipleInheritence obj = new MultipleInheritence();
        obj.display();
    }

    // for default method with java 8 we have a chance to face diamond problem
    // but java developers make sure the implementor should implements the default method also;
    // which will remove the risk of diamond problem
    @Override
    public void display() {
        MyInterface1.super.display();
        MyInterface2.super.display();
    }
}
