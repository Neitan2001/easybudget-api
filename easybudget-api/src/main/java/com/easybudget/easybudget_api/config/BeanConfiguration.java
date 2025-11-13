package com.easybudget.easybudget_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.easybudget.easybudget_api.adapters.out.security.BCryptPasswordEncoderAdapter;
import com.easybudget.easybudget_api.domain.ports.in.ILogInUserUseCase;
import com.easybudget.easybudget_api.domain.ports.in.IRegisterUserUseCase;
import com.easybudget.easybudget_api.domain.ports.out.IPasswordEncoder;
import com.easybudget.easybudget_api.domain.ports.out.IUserRepository;
import com.easybudget.easybudget_api.domain.service.LogInUserService;
import com.easybudget.easybudget_api.domain.service.RegisterUserService;

@Configuration
public class BeanConfiguration {

    @Bean
    public IPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoderAdapter();
    }

    @Bean
    public IRegisterUserUseCase registerUserUseCase(
        IUserRepository userRepository,
        IPasswordEncoder passwordEncoder
    ){
        return new RegisterUserService(userRepository, passwordEncoder);
    }

    @Bean
    public ILogInUserUseCase logInUserUseCase(
        IUserRepository userRepository,
        IPasswordEncoder passwordEncoder
    ){
        return new LogInUserService(userRepository, passwordEncoder);
    }
}
