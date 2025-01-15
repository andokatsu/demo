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
        // パスワードの暗号化用
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register", "/login").permitAll() // 特定のURLを認証不要に設定
                        .anyRequest().authenticated() // それ以外のリクエストは認証が必要
                )
                .formLogin(form -> form
                        .loginPage("/login") // ログインページのURL
                        .defaultSuccessUrl("/") // ログイン成功後のリダイレクト先
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll // ログアウトを全員許可
                );

        return http.build();
    }
}

