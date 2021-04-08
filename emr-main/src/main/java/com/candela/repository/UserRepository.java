package com.candela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.candela.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByMailId(String mailId);
    User findByName(String name);
}
