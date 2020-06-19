package practice;

import java.util.List;

class Address {
    int pinCode;
    String area;
    Address() {

    }
    Address(int pinCode, String area) {
        this.pinCode = pinCode;
        this.area = area;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

final class Employees {
    private final int eid;
    private final String eName;
    private final Address address;

    public Employees(int eid, String eName, Address add) {
        this.eid = eid;
        this.eName = eName;
        this.address = new Address();  //defensive copy
        this.address.setArea(add.getArea());
        this.address.setPinCode(add.getPinCode());
    }
    public int getEid() {
        return eid;
    }
    public String geteName() {
        return eName;
    }

    public Address getAddress() {
        Address newAdd = new Address();  // must copy
        newAdd.setPinCode(address.getPinCode());
        newAdd.setArea(address.getArea());
        return newAdd;
    }
}
public class ImmutableClassConcept {
    public static void main(String[] args) {
        new ImmutableClassConcept().run();
    }

    private void run() {
        Employees emp = new Employees(1,"Aashish", new Address(12345,"Delhi6"));

        emp.getAddress().setArea("Delhi 76");

        System.out.println(emp.getEid());
        System.out.println(emp.geteName());
        System.out.println(emp.getAddress().getArea() +" "+emp.getAddress().getPinCode());
    }
}
