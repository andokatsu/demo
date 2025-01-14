package com.example.demo.model;

import jakarta.persistence.*;  // JPAを使用するために必要なインポート

@Entity  // このクラスがJPAエンティティであることを示すアノテーション
@Table(name = "users")  // このエンティティがマッピングされるテーブル名を指定
public class User {

    @Id  // 主キーを示すアノテーション
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 主キーの自動生成戦略を指定
    private Long id;

    @Column(nullable = false, unique = true)  // ユーザー名をユニークかつNULL禁止に設定
    private String username;

    @Column(nullable = false)  // パスワードはNULLを許容しない
    private String password;

    // GetterとSetterメソッドは、プロパティへのアクセスのために必要です
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
