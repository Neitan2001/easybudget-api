package com.easybudget.easybudget_api.domain.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String email) {
        super("The email '" + email + "' is already registered");
    }
}
