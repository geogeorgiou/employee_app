package com.login.employee.exception;

//custom Exception thrown when duplicate mail found when creating new admin,user
public class DuplicateEmailException extends RuntimeException{

    public DuplicateEmailException() {
    }

    public DuplicateEmailException(String message)
    {
        super(message + " mail already exists in DB!");
    }

}
