package com.bbu.controller;

import com.bbu.model.User;
import com.bbu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {
    final
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/loginPage")      //登录按钮
    public String toLoginPage(){
        return "login";
    }
    @RequestMapping("/registPage")
    public String toRegistPage(){
        return "regist";
    }
    @RequestMapping("/exit")      //退出按钮
    public String exit(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }
    @RequestMapping("/login")   //登录
    public String login(@ModelAttribute User user,HttpServletRequest request,Model model){

        if (userService.login(user.getMail(),user.getPwd())){
            System.out.println("登录成功");
            request.getSession().setAttribute("user",userService.getUser(user.getMail()));
            return "redirect:/";
        }
        else{
            System.out.println("登录失败");
            model.addAttribute("logMsg","密码或账号错误");
        }
        System.out.println(user.getMail()+user.getPwd());
        return "login";
    }


    @PostMapping("/register")     //注册
    public String register(@ModelAttribute User user, Model model){
        ModelAndView mv = new ModelAndView("/login");
        if (userService.regist(user)) {
            model.addAttribute("logMsg", "注册成功 ");
            return "login";
        }
        else{
            model.addAttribute("regMsg","用户名或邮箱已存在");
            return "regist";
        }
    }


}
