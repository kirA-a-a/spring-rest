package com.safronov.spring.rest.exeption_handling;

public class NoSuchEmployeeExtension extends RuntimeException {

    public NoSuchEmployeeExtension(String message) {
        super(message);
    }

}
