package com.example.lab2sdi.exceptions;

public class HospitalNotFoundException extends RuntimeException{
    public HospitalNotFoundException(Long id){
        super("Could not find hospital "+ id);
    }
}
