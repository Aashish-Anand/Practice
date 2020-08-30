package javaConcept.inheritance;

public class PayrollSystemTest {
    public static void main(String[] args) {
        SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111", 800.00);

        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222", 16.75, 40);

        CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333", 1000, .06);

        BasePlusCommissionemployee basePlusCommissionemployee = new BasePlusCommissionemployee("Bob","Lewis","444",5000, .04, 300);

        System.out.println("Salaried employee : "+salariedEmployee+" earned"+salariedEmployee.earnings());
        System.out.println("Hourly employee : "+hourlyEmployee+" earned"+hourlyEmployee.earnings());
        System.out.println("Commission employee : "+commissionEmployee+" earned"+commissionEmployee.earnings());
        System.out.println("BasePlusCommission employee : "+basePlusCommissionemployee+" earned"+basePlusCommissionemployee.earnings());

        Employee[] employees = new Employee[4];
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionemployee;

        for(Employee currentEmployee : employees){
            System.out.println(currentEmployee);
            if(currentEmployee instanceof BasePlusCommissionemployee){
                BasePlusCommissionemployee employee = (BasePlusCommissionemployee) currentEmployee;
                employee.setBaseSalary(1.10*employee.getBaseSalary());

                System.out.println("new Base salary : "+employee.getBaseSalary());
            }

            System.out.println(currentEmployee.earnings());
        }


    }
}
