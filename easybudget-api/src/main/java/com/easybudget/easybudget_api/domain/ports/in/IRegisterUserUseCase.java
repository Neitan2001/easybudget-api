package com.easybudget.easybudget_api.domain.ports.in;

import com.easybudget.easybudget_api.domain.model.User;

public interface IRegisterUserUseCase {

    User register(String name, String email, String password);
}
