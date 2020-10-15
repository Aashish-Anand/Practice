package designPattern;

abstract class Vehicle{
    public abstract int getWheels();

    public String toString() {
        return "Number of wheels : " + getWheels();
    }
}
class Car extends Vehicle {
    private int wheels;
    Car(int wheels){
        this.wheels = wheels;
    }

    @Override
    public int getWheels() {
        return wheels;
    }
}

class Bike extends Vehicle {
    private int wheels;
    Bike(int wheels){
        this.wheels = wheels;
    }

    @Override
    public int getWheels() {
        return wheels;
    }
}

class FactoryClass {
    public static Vehicle getInstance(String type, int wheels) {
        if(type.equals("Bike")) {
            return new Bike(wheels);
        }
        else if(type.equals("Car")) {
            return new Car(wheels);
        }
        return null;
    }
}

public class SimpleFactory {
    public static void main(String[] args) {
        Vehicle v1 = FactoryClass.getInstance("Bike",2);
        System.out.println(v1.toString());

        Vehicle v2 = FactoryClass.getInstance("Car", 4);
        System.out.println(v2.toString());
    }
}
