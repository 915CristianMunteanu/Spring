package com.example.lab2sdi.exceptions;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(Long id){
        super("Could not find patient "+ id);
    }
}
