package com.tomasmoore.assetmanagement.exceptions;

public class NoEmployeesFoundException extends RuntimeException {
    public NoEmployeesFoundException(String message) {
        super(message);
    }
}
