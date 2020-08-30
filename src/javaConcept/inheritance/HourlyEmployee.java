package javaConcept.inheritance;

public class HourlyEmployee extends Employee{
    private double wage;
    private double hours;


    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
        super(firstName,lastName,socialSecurityNumber);

        this.wage = wage;
        this.hours = hours;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f", super.toString(), "hourly wage", getWage(),"hoursWorked",getHours());
    }

    @Override
    public double earnings() {
        return 40 * getWage() + (getHours()-40)*getWage()*1.5;
    }

}
