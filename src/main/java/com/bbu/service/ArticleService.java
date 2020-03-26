package com.bbu.service;

import com.bbu.mapper.ArticleMapper;
import com.bbu.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    public String create(Article article){
        if (article.getTitle()==null || article.getTitle() == ""){
            return "标题不能为空";
        }
        else if (article.getContent() == null || article.getContent() ==""){
            return "文章内容不能为空";
        }
        articleMapper.create(article);
        return "发布成功";
    }
}
