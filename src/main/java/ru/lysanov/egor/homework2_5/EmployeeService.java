package ru.lysanov.egor.homework2_5;

import org.springframework.stereotype.Service;
import ru.lysanov.egor.homework2_5.exceptions.EmployeeAlreadyAddedException;
import ru.lysanov.egor.homework2_5.exceptions.EmployeeNotFoundException;
import ru.lysanov.egor.homework2_5.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<String> Employees = new ArrayList<>();


    public String addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (Employees.size() > 1) {
            throw new EmployeeStorageIsFullException("Employee storage is full");
        } else if (Employees.contains(String.valueOf(employee))) {
            throw new EmployeeAlreadyAddedException("Employee is already added");
        } else {
            Employees.add(String.valueOf(employee));
        }
        return employee.toString();
    }

    public String removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (Employees.contains(String.valueOf(employee))) {
            return "Employee removed";
        } else {
            throw new EmployeeNotFoundException("Employee don^t finded");
        }
    }

    public String findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (Employees.contains(String.valueOf(employee))) {
            return "Employee finded";
        } else {
            throw new EmployeeNotFoundException("Employee don^t finded");
        }
    }

    public String printAllEmployees() {
        System.out.println(Employees.toString());
        return Employees.toString();
    }
}
