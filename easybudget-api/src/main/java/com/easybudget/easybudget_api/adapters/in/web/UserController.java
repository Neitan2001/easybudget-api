package com.easybudget.easybudget_api.adapters.in.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybudget.easybudget_api.adapters.in.web.dto.LogInUserRequestDTO;
import com.easybudget.easybudget_api.adapters.in.web.dto.LogInUserResponseDTO;
import com.easybudget.easybudget_api.adapters.in.web.dto.RegisterUserRequestDTO;
import com.easybudget.easybudget_api.adapters.out.security.JwtTokenAdapter;
import com.easybudget.easybudget_api.domain.model.User;
import com.easybudget.easybudget_api.domain.ports.in.ILogInUserUseCase;
import com.easybudget.easybudget_api.domain.ports.in.IRegisterUserUseCase;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private final IRegisterUserUseCase registerUserUseCase;
    private final ILogInUserUseCase logInUserUseCase;
    private final JwtTokenAdapter jwtTokenAdapter;

    public UserController(
        IRegisterUserUseCase registerUserUseCase,
        ILogInUserUseCase logInUserUseCase,
        JwtTokenAdapter jwtTokenAdapter
    ) {
        this.registerUserUseCase = registerUserUseCase;
        this.logInUserUseCase = logInUserUseCase;
        this.jwtTokenAdapter = jwtTokenAdapter;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterUserRequestDTO requestDTO) {
        
        registerUserUseCase.register(
            requestDTO.getName(), 
            requestDTO.getEmail(), 
            requestDTO.getPassword()
        );
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<LogInUserResponseDTO> login(@Valid @RequestBody LogInUserRequestDTO requestDTO) {
        
        User user = logInUserUseCase.login(
            requestDTO.getEmail(), 
            requestDTO.getPassword()
        );

        String token = jwtTokenAdapter.generateToken(user);

        return ResponseEntity.ok(new LogInUserResponseDTO(token));
    }
    
    
}
