package com.login.webapp.exception;

//custom Exception thrown when duplicate mail found
public class DuplicateEmailException extends RuntimeException{

    public DuplicateEmailException() {
    }

    public DuplicateEmailException(String message)
    {
        super(message + " mail already exists in DB!");
    }

}
