package com.selva.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selva.task.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByPhone(String phone);
}