package com.easybudget.easybudget_api.domain.ports.out;

import java.util.Optional;

import com.easybudget.easybudget_api.domain.model.User;

public interface IUserRepository {

    User save(User user);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
