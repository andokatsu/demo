package com.example.demo.service;

import com.example.demo.model.User;

import java.util.Optional;

// ユーザー関連のビジネスロジックを処理するサービスインターフェース
public interface UserService {
    void save(User user);  // ユーザーを保存するメソッド
    Optional<User> findByUsername(String username);  // ユーザー名でユーザーを検索するメソッド
}

