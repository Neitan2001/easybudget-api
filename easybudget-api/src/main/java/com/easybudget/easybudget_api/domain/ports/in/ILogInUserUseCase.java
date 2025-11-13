package com.easybudget.easybudget_api.domain.ports.in;

import com.easybudget.easybudget_api.domain.model.User;

public interface ILogInUserUseCase {

    User login(String email, String password);
}
