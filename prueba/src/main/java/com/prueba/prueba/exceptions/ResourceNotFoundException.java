package com.prueba.prueba.exceptions;

public class ResourceNotFoundException extends Exception{

    public ResourceNotFoundException(String message, String id, Integer integer){
        super(message);

    }
    public ResourceNotFoundException(String message){
        super(message);
    }

}
