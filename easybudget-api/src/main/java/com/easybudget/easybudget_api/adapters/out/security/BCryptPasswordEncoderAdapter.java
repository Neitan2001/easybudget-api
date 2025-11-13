package com.easybudget.easybudget_api.adapters.out.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.easybudget.easybudget_api.domain.ports.out.IPasswordEncoder;

public class BCryptPasswordEncoderAdapter implements IPasswordEncoder {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String hash(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }

}
