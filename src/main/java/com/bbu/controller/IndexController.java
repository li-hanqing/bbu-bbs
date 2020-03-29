package com.bbu.controller;

import com.bbu.dto.ArticleDTO;
import com.bbu.model.Article;
import com.bbu.service.ArticleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    ArticleService articleService;
    @GetMapping("/")
    public String getArticleList(Model model,HttpServletRequest request,
                                 @RequestParam(value = "pageNum",defaultValue = "1",required = false)int pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "9")int pageSize){
        request.getSession(true);
        Page page = PageHelper.startPage(pageNum,pageSize);
        List<ArticleDTO> articleDTOS = articleService.getArticleDTOS();
        PageInfo<ArticleDTO> pageInfo = new PageInfo<>(page.getResult());
        model.addAttribute("articles",articleDTOS);  //获取文章传输对象放到前端
        model.addAttribute("pageInfo",pageInfo);

        return "index";

    }
}
