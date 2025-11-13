package com.easybudget.easybudget_api.domain.exception;

public class IncorretPasswordException extends RuntimeException {

    public IncorretPasswordException() {
        super("This password is incorrect");
    }
}
