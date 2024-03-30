package com.gx.sp3.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafController {
    /**
     * Access this method by http://localhost:8080/gxsp3demo/
     * @return
     */
    @GetMapping(value = "/")
    public String index(Model model) {
        try {
            System.out.println("!!! ThymeleafController#index entering");
            model.addAttribute("msg","Thymeleaf入门案例...");
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail: " + e.toString();
        }
    }

    /**
     * Access this method by http://localhost:8080/gxsp3demo/login
     * @return
     */
    @GetMapping("/login")
    public String login(Model model, @RequestParam(name="error", required = false) String error) {
        model.addAttribute("error", error);
        return "login";
    }

    @PostMapping("/loginAction")
    public String loginAction() {
        System.out.printf("!!! ThymeleafController#loginAction entering\n");
        // 处理登录逻辑
        return "redirect:/welcome"; // 登录成功后跳转的页面
    }
}
