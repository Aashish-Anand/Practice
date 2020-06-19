package javaConcept;

final class immutable {
    final int roll;
    final String name;

    immutable(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

//    public void setRoll(int roll) {
//        this.roll = roll;
//    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
}

public class ImmutableClasses {
    public static void main(String[] args) {
        new ImmutableClasses().run();
    }

    private void run() {
        immutable im = new immutable(1, "Aashish");
        System.out.println(im.getName() + " " + im.getRoll());

    }
}
