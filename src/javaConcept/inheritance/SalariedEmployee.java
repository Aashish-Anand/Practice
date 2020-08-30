package javaConcept.inheritance;

public class SalariedEmployee extends Employee{
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
        super(firstName,lastName,socialSecurityNumber);

        this.weeklySalary = weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary){
        if(weeklySalary<0.0){
            throw new IllegalArgumentException("Salry should be >= 0.0");
        }
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return String.format("Salaried employee: %s%n%s: $%, .2f", super.toString(),"weeklySalary: ",getWeeklySalary());
    }

    @Override
    public double earnings() {
        return this.getWeeklySalary();
    }
}
