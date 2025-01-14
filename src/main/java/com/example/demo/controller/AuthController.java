package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller  // Spring MVCのコントローラーとして定義
public class AuthController {

    @Autowired
    private UserService userService;  // UserServiceをインジェクト

    @GetMapping("/register")  // GETリクエストを受け付けるメソッド
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());  // 新しいUserオブジェクトをモデルに追加
        return "register";  // "register"というテンプレートに遷移
    }

    @PostMapping("/register")  // POSTリクエストを受け付けるメソッド
    public String registerUser(User user) {
        userService.save(user);  // ユーザーを保存
        return "redirect:/login";  // 登録後にログインページへリダイレクト
    }
}
