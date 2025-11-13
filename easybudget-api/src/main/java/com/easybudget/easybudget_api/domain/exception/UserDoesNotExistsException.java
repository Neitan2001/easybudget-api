package com.easybudget.easybudget_api.domain.exception;

public class UserDoesNotExistsException extends RuntimeException {

    public UserDoesNotExistsException(String email) {
        super("There is no user registered with this email: '" + email + "'");
    }
}
