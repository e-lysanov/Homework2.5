package ru.lysanov.egor.homework2_5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.lysanov.egor.homework2_5.exceptions.EmployeeAlreadyAddedException;
import ru.lysanov.egor.homework2_5.exceptions.EmployeeNotFoundException;
import ru.lysanov.egor.homework2_5.exceptions.EmployeeStorageIsFullException;
@RequestMapping(path = "/employee")
@RestController
public class Controller {

    private final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


//    @RequestMapping(path = "/employee")
    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName) {
        try {
            return employeeService.addEmployee(firstName, lastName);
        } catch (EmployeeStorageIsFullException exception) {
            exception.printStackTrace();
            return "Employee storage is full";
        } catch (EmployeeAlreadyAddedException exception) {
            exception.printStackTrace();
            return "Employee is already added";
        }
    }


    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName) {
        try {
            return employeeService.removeEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException exception) {
            exception.printStackTrace();
            return "Employee don^t finded";
        }
    }


    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName) {
        try {
            return employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException exception) {
            exception.printStackTrace();
            return "Employee don^t finded";
        }
    }

    @GetMapping(path = "/printAll")
    public String printAllEmployees() {
        return employeeService.printAllEmployees();
    }
}
