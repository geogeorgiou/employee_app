package com.login.employee.exception;

//this exception is thrown when employee has his supervisor as descendant or himself

public class CyclicChildException extends Exception {

    public CyclicChildException(String message) {
        super(message);
    }

    public CyclicChildException(String child, String parent){
        super("Cyclic child-parent reference between {" + child + "} and {"+parent+"}");
    }
}
