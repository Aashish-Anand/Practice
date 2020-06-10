package javaConcept;

interface A {
    void a();
    void b();
    void c();
    void d();
}
abstract class B implements A {
    public void b(){
        System.out.println("Implementing the A method in abstract class");
    }
    public abstract void abs();
    public void nonabs() {

    }

}
class M extends B {

    @Override
    public void a() {
        System.out.println("Implementing the a method");
    }

    @Override
    public void c() {
        System.out.println("Implementing the b method");
    }

    @Override
    public void d() {
        System.out.println("Implementing the d method");
    }

    @Override
    public void abs() {

    }
    public void nonabs(){
        System.out.println("none abs in child");
    }
}
public class AbstractExample{
    public static void main(String[] args) {
        A a=new M();
        a.a();
        a.b();
        a.c();
        a.d();
        B b = new M();
        b.abs();
        b.a();
        b.c();
        b.d();
        b.nonabs();
    }
}
