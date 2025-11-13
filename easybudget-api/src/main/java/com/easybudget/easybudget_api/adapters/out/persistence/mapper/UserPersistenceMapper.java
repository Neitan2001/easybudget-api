package com.easybudget.easybudget_api.adapters.out.persistence.mapper;

import org.springframework.stereotype.Component;

import com.easybudget.easybudget_api.adapters.out.persistence.entity.UserEntity;
import com.easybudget.easybudget_api.domain.model.User;

@Component
public class UserPersistenceMapper {

    public UserEntity toEntity(User userDomain) {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(userDomain.getId());
        userEntity.setName(userDomain.getName());
        userEntity.setEmail(userDomain.getEmail());
        userEntity.setPassword(userDomain.getPassword());
        
        return userEntity;
    }

    public User toDomain(UserEntity userEntity) {
        return new User(
            userEntity.getId(),
            userEntity.getName(),
            userEntity.getEmail(),
            userEntity.getPassword()
        );
    }
}
