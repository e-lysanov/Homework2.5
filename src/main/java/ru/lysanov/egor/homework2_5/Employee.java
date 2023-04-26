package ru.lysanov.egor.homework2_5;

public class Employee {
    private String fullName;
    private int department;
    private int salary;
    private int id;

    public static int idCounter = 0;

    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        idCounter++;
        id = idCounter;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Сотрудник: " + fullName +
                ", отдел: " + department +
                ", зарплата: " + salary + " рублей" +
                ", id: " + id;
    }
}
