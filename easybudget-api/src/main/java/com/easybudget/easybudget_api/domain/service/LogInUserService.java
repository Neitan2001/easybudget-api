package com.easybudget.easybudget_api.domain.service;

import com.easybudget.easybudget_api.domain.exception.IncorretPasswordException;
import com.easybudget.easybudget_api.domain.exception.UserDoesNotExistsException;
import com.easybudget.easybudget_api.domain.model.User;
import com.easybudget.easybudget_api.domain.ports.in.ILogInUserUseCase;
import com.easybudget.easybudget_api.domain.ports.out.IPasswordEncoder;
import com.easybudget.easybudget_api.domain.ports.out.IUserRepository;

public class LogInUserService implements ILogInUserUseCase {

    private final IUserRepository userRepository;
    private final IPasswordEncoder passwordEncoder;

    public LogInUserService(IUserRepository userRepository, IPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(
            () -> new UserDoesNotExistsException(email)
        );

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IncorretPasswordException();
        }

        return user;
    }

}
