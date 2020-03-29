package com.bbu.controller;

import com.bbu.dto.ArticleDTO;
import com.bbu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @GetMapping("/article/{id}")
    public String viewArticle(@PathVariable(value = "id")Integer id, Model model){

        ArticleDTO articleDTO = articleService.getArticleDTObyId(id);
        model.addAttribute("articleDTO",articleDTO);
        return "article";
    }
}
