package javaConcept.Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeTest {
    public class Employee {
        private String firstName;
        private String lastName;
        private double salary;
        private String department;

        public Employee(String firstName, String lastName, double salary, String department) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
            this.department = department;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getName() {
            return getFirstName()+" " +getLastName();
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", salary=" + salary +
                    ", department='" + department + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        new EmployeeTest().run();
    }

    private void run() {
        Employee[] employee = {
                new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Ashley", "Green", 7600, "IT"),
                new Employee("Matthew", "Indigo", 3587.32, "Sales"),
                new Employee("James", "Indigo", 4700, "Marketing"),
                new Employee("Luke", "Indigo", 6200, "IT"),
                new Employee("Jason", "Blue", 3200, "Sales"),
                new Employee("Wendy", "Brown", 4236.5, "Marketing")
        };

        List<Employee> employeeList = Arrays.asList(employee);

        System.out.println("Complete list of Employees : ");
        employeeList.stream().forEach(System.out::println);

        // filtering
        Predicate<Employee> fourToSixThousand = e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

        System.out.println();
        System.out.println("Employee earning between 4 to 6K : ");
        employeeList.stream().filter(fourToSixThousand).sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

        System.out.println("\nFirst employee who earn between 4 to 6K : " + employeeList.stream().filter(fourToSixThousand).findFirst().get());


        // function

        Function<Employee, String> byFirstName = Employee::getFirstName;
        Function<Employee, String> byLastName = Employee::getLastName;

        Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);

        System.out.println("\nEmployee in ascending order of last name then first ");
        employeeList.stream().sorted(lastThenFirst).forEach(System.out::println);

        System.out.println("\nEmployee in descending order of last name then first ");
        employeeList.stream().sorted(lastThenFirst.reversed()).forEach(System.out::println);

        System.out.println("\n Unique emplyee last name : ");
        employeeList.stream().map(Employee::getLastName).distinct().sorted().forEach(System.out::println);

        System.out.println("\n only Employee name in order of last name and first name : ");
        employeeList.stream().sorted(lastThenFirst).map(Employee::getName).forEach(System.out::println);

        System.out.println();
        // group employee by department
        Map<String, List<Employee>> groupedByDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        groupedByDepartment.forEach(
                (department, employeeInDepartment) -> {
                    System.out.println(department);
                    employeeInDepartment.forEach(
                            employee1 -> System.out.println(employee1)
                    );
                }
        );

        // count of emplyee by department
        System.out.println("\nCount of employee by department : ");
        Map<String, Long> employeeCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        employeeCount.forEach((department, count) -> System.out.println(department+" "+count));

        // sum of employee salries with double Stream
        System.out.println("\nSum of all salaries: "+employeeList.stream().mapToDouble(Employee::getSalary).sum());

        // sum of emplyee salries with reduce
        System.out.println("\nSum of all salaries with reduce : "+ employeeList.stream().mapToDouble(Employee::getSalary).reduce(0, (input1, input2 )-> input1+input2));

        System.out.println("\nAverage of employee : "+ employeeList.stream().mapToDouble(Employee::getSalary).average().getAsDouble());
    }
}
