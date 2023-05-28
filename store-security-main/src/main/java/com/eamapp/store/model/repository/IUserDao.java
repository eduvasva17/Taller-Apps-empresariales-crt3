package com.eamapp.store.model.repository;

import com.eamapp.store.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserDao extends JpaRepository<User, Long> {
    Optional<User> findOneByEmail(String email);
}
