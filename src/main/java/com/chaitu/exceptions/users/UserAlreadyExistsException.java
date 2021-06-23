package com.chaitu.exceptions.users;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
