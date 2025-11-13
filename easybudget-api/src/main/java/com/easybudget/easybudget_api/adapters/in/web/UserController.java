package com.easybudget.easybudget_api.adapters.in.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybudget.easybudget_api.adapters.in.web.dto.RegisterUserRequestDTO;
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

    public UserController(IRegisterUserUseCase registerUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
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
    
}
