package com.auth.auth_app.exceptions;

public class UserNotFound extends RuntimeException {

    public UserNotFound(String message) {
        super(message);
    }
    public UserNotFound() {
        super("User not found");
    }

}
