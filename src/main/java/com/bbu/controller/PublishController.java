package com.bbu.controller;

import com.bbu.model.Article;
import com.bbu.model.User;
import com.bbu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    ArticleService articleService;
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
    @PostMapping("/publish")
    public String doPublish(@ModelAttribute Article article, Model model, HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return "login";
        }
        article.setGmtCreate(System.currentTimeMillis());
        article.setGmtModified(article.getGmtCreate());
        article.setCreator(user.getUserName());
        String s = articleService.create(article); //返回文章创建成功与否的信息
        model.addAttribute("pubMsg",s);
        if (s.equals("发布成功")==false){           //为发布成功则回显数据
            model.addAttribute("title",article.getTitle());
            model.addAttribute("content",article.getContent());
            model.addAttribute("tag",article.getTag());
        }
        return "publish";
    }
}
