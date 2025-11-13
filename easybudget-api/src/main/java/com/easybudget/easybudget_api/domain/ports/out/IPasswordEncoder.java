package com.easybudget.easybudget_api.domain.ports.out;

public interface IPasswordEncoder {

    String hash(String rawPassword);
    boolean matches(String rawPassword, String encodedPassword);
}
