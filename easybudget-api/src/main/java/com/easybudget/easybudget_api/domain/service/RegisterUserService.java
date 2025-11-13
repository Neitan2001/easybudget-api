package com.easybudget.easybudget_api.domain.service;

import com.easybudget.easybudget_api.domain.exception.EmailAlreadyExistsException;
import com.easybudget.easybudget_api.domain.model.User;
import com.easybudget.easybudget_api.domain.ports.in.IRegisterUserUseCase;
import com.easybudget.easybudget_api.domain.ports.out.IPasswordEncoder;
import com.easybudget.easybudget_api.domain.ports.out.IUserRepository;

public class RegisterUserService implements IRegisterUserUseCase{
    
    private final IUserRepository userRepository;
    private final IPasswordEncoder passwordEncoder;

    public RegisterUserService(IUserRepository userRepository, IPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String name, String email, String password) {
        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException(email);
        }

        String encodedPassword = passwordEncoder.hash(password);

        User newUser = new User(name, email, encodedPassword);
        
        return userRepository.save(newUser);
    }
}
