package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        //.requestMatchers("/register", "/login").permitAll() // ログインページと登録ページは許可
                        .requestMatchers("/login").permitAll() // /loginへのアクセスを許可
                        .anyRequest().authenticated() // 他のページは認証が必要
                )
                .formLogin(form -> form
                        .loginPage("/login") // ログインページ
                        .defaultSuccessUrl("/home", true) // ログイン成功後にホームページへリダイレクト
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll); // ログアウトを許可

        return http.build();
    }
}


