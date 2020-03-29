package com.bbu.controller;

import com.bbu.dto.ArticleDTO;
import com.bbu.mapper.ArticleMapper;
import com.bbu.model.Article;
import com.bbu.model.User;
import com.bbu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String doPublish(@ModelAttribute Article article,
                            Model model,
                            HttpServletRequest request,
                            @RequestParam(name = "id",required = false)Integer id){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return "login";
        }
        article.setCreator(user.getUserName());
        article.setId(id);
        String msg = articleService.create(article); //创建文章并返回文章创建成功与否的信息
        model.addAttribute("pubMsg",msg);
        if (msg.equals("发布成功")==false){           //发布失败则回显数据文章信息
            model.addAttribute("title",article.getTitle());
            model.addAttribute("content",article.getContent());
            model.addAttribute("tag",article.getTag());
        }else if (id!=null) {
            return "redirect:/article/" +id;
        }
        return "redirect:/profile/article";
    }

    @GetMapping("/publish/{articleId}")   //编辑文章请求
    public String  updateArticle(@PathVariable(name = "articleId") Integer articleId,Model model){
        ArticleDTO articleDTO = articleService.getArticleDTObyId(articleId);
        model.addAttribute("title",articleDTO.getTitle());
        model.addAttribute("content",articleDTO.getContent());
        model.addAttribute("tag",articleDTO.getTag());
        model.addAttribute("id",articleId);
        return "publish";
    }
}
