package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service  // Springが自動的にこのクラスをサービスコンポーネントとして管理
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;  // UserRepositoryのインジェクション

    @Autowired
    private PasswordEncoder passwordEncoder;  // パスワードエンコーダのインジェクション

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));  // パスワードをハッシュ化
        userRepository.save(user);  // ユーザー情報をリポジトリに保存
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);  // ユーザー名でユーザーを検索
    }
}
