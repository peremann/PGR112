package eksempler._17.employee;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeProvider ep = new EmployeeProvider();
        try {
            List<Employee> employees = ep.getAllEmployees();
            System.out.println("Printing all employees");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
            List<RegularEmployee> regularEmployees = ep.getAllRegularEmployees();
            System.out.println("Printing all regular employees");
            for (RegularEmployee regularEmployee : regularEmployees) {
                System.out.println(regularEmployee);
            }
            RegularEmployee newEmployee = ep.addRegularEmployee("Per", 10000.00f, 1000);
            System.out.println("Look: I have a new employee!");
            System.out.println(newEmployee);

        } catch (SQLException e) {
            System.out.println("Exception caught:"+e.getMessage());
        }
    }

}
