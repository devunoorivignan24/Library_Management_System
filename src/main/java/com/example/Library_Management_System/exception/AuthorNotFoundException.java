package com.example.Library_Management_System.exception;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(String message){
        super(message);
    }
}
