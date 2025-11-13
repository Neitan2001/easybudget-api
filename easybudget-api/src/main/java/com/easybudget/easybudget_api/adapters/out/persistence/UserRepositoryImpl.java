package com.easybudget.easybudget_api.adapters.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.easybudget.easybudget_api.adapters.out.persistence.entity.UserEntity;
import com.easybudget.easybudget_api.adapters.out.persistence.mapper.UserPersistenceMapper;
import com.easybudget.easybudget_api.domain.model.User;
import com.easybudget.easybudget_api.domain.ports.out.IUserRepository;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    private final SpringDataUserRepository jpaRepository;
    private final UserPersistenceMapper mapper;

    public UserRepositoryImpl(SpringDataUserRepository jpaRepository, UserPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public User save(User user) {
        UserEntity entity = mapper.toEntity(user);

        UserEntity savedEntity = jpaRepository.save(entity);

        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> entityOptional = jpaRepository.findByEmail(email);

        return entityOptional.map(mapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }

}
