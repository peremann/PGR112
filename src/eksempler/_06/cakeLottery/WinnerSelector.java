package eksempler._06.cakeLottery;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class WinnerSelector {

    private ArrayList<Employee> employees = new ArrayList<>();

    public Employee pickWinner(){
        Random r = new Random();
        int index = r.nextInt(employees.size());
        return employees.remove(index);
    }

    public void populateEmployees(String fileName) throws FileNotFoundException {
        EmployeeReader reader = new EmployeeReader();
        ArrayList<Employee> employeesReadFromFile = reader.readEmployeesFromFile(fileName);
        employees.addAll(employeesReadFromFile);
        //employees = reader.readEmployeesFromFile(fileName);
        /*
        Employee employee1 = new Employee();
        employee1.setEmail("jens@tull.no");
        employee1.setName("Jens");
        employee1.setAge(21);
        employees.add(employee1);

        Employee employee2 = new Employee();
        employee2.setEmail("per@tull.no");
        employee2.setName("Per");
        employee2.setAge(22);
        employees.add(employee2);

        Employee employee3 = new Employee();
        employee3.setEmail("ina@tull.no");
        employee3.setName("Ina");
        employee3.setAge(24);
        employees.add(employee3);

         */
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}
