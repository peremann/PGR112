package eksempler._06.cakeLottery;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeReader {
    // We need to know what file to read from
    //String filename = "files/employees.txt";

    // We will offer a method for reading employees from a file and return them.
    public ArrayList<Employee> readEmployeesFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        ArrayList<Employee> employeesToReturn = new ArrayList<>();
        while(scanner.hasNextLine()){
            String name = scanner.nextLine();
            String email = scanner.nextLine();
            String ageAsText = scanner.nextLine();
            int age = Integer.parseInt(ageAsText);
            scanner.nextLine(); // Swallowing ---
            Employee emp = new Employee();
            emp.setName(name);
            emp.setEmail(email);
            emp.setAge(age);
            employeesToReturn.add(emp);
        }
        return employeesToReturn;
    }
}
