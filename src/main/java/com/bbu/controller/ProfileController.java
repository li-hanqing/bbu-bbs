package com.bbu.controller;

import com.bbu.dto.ArticleDTO;
import com.bbu.mapper.ArticleMapper;
import com.bbu.model.Article;
import com.bbu.model.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    ArticleMapper articleMapper;

    @GetMapping("/profile/article")
    public String profile(
                          Model model,
                          HttpServletRequest request,
                          @RequestParam(value = "pageNum",defaultValue = "1",required = false)int pageNum,
                          @RequestParam(value = "pageSize",defaultValue = "9")int pageSize){
        User user = (User) request.getSession().getAttribute("user");
        Page page = PageHelper.startPage(pageNum,pageSize);
        List<Article> list = articleMapper.getArticlesByCreator(user.getUserName());
        PageInfo<Article> pageInfo = new PageInfo<>(page.getResult());
        model.addAttribute("pageInfo",pageInfo);
        return "profile";
    }
}
