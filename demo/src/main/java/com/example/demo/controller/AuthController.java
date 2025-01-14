package com.example.demo.controller;

import com.example.demo.model.User;  // Userエンティティをインポート
import com.example.demo.service.UserService;  // UserServiceをインポート
import org.springframework.beans.factory.annotation.Autowired;  // DIのインポート
import org.springframework.stereotype.Controller;  // Controllerアノテーションのインポート
import org.springframework.web.bind.annotation.GetMapping;  // GETリクエスト用のアノテーション
import org.springframework.web.bind.annotation.PostMapping;  // POSTリクエスト用のアノテーション
import org.springframework.ui.Model;  // Thymeleafテンプレートにデータを渡すためのインポート

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
