package com.auth.auth_app.exceptions;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(String message){
        super(message);
    }
    public ResourceNotFound(){
        super("Resource Not Found !!!");
    }
}
