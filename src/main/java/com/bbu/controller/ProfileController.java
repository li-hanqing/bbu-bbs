package com.bbu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {
    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action, Model model){
        if (action.equals("article")){
            model.addAttribute("section","article");
            model.addAttribute("sectionName","我的文章");

        }
        else if ("replies".equals(action)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","回复");
        }
        return "profile";
    }
}
