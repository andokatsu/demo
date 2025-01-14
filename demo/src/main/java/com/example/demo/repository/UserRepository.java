package com.example.demo.repository;

import com.example.demo.model.User;// Userエンティティのインポート
import org.springframework.data.jpa.repository.JpaRepository;// JpaRepositoryのインポート

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

