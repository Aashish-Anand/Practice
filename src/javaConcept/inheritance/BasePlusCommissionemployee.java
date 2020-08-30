package javaConcept.inheritance;

public class BasePlusCommissionemployee extends CommissionEmployee{
    private double baseSalary;

    public BasePlusCommissionemployee(String firstName, String lastname, String socialSecurityNumber, double grossSales, double commisionDate, double baseSalary) {
        super(firstName,lastname,socialSecurityNumber,grossSales,commisionDate);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; %s: $%,.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
    }

    @Override
    public double earnings() {
        return super.earnings() + getBaseSalary();
    }
}
