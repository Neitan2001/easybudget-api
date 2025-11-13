package com.easybudget.easybudget_api.adapters.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easybudget.easybudget_api.adapters.out.persistence.entity.UserEntity;

@Repository
public interface SpringDataUserRepository extends JpaRepository<UserEntity, String>{

    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);

}
