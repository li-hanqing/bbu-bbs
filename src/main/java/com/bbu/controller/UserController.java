package com.bbu.controller;

import com.bbu.pojo.User;
import com.bbu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public void login(@ModelAttribute User user){
        if (userService.login(user.getMail(),user.getPwd()))
            System.out.println("登录成功");
        else
            System.out.println("登录失败");
        System.out.println(user.getMail()+user.getPwd());
        return ;
    }

    @RequestMapping("/register")
    public void register(@ModelAttribute User user,Model model){
        if (userService.regist(user))
            model.addAttribute("regMsg","成功");
        else{
            model.addAttribute("regMsg","失败");
        }

    }

}
