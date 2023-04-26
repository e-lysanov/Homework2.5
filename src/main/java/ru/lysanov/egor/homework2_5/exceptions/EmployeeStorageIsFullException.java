package ru.lysanov.egor.homework2_5.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
