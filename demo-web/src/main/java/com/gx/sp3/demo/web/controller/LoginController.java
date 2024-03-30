package com.gx.sp3.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    /**
     * Access this method by http://localhost:8080/gxsp3demo/test000
     * @return
     */
    @GetMapping(value = "/")
    public String index(Model model) {
        try {
            System.out.println("!!! RootController#index entering");
            model.addAttribute("msg","Thymeleaf入门案例...");
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail: " + e.toString();
        }
    }

    @GetMapping("/login")
    public String login() {
        System.out.printf("!!! LoginController#login entering\n");
        return "login";
    }
}
