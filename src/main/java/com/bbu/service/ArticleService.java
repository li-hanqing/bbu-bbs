package com.bbu.service;

import com.bbu.dto.ArticleDTO;
import com.bbu.mapper.ArticleMapper;
import com.bbu.mapper.UserMapper;
import com.bbu.model.Article;
import com.bbu.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;

    public String create(Article article){              //发布文章进行逻辑判断
        if (article.getTitle()==null || article.getTitle() == ""){
            return "标题不能为空";
        }
        else if (article.getContent() == null || article.getContent() ==""){
            return "文章内容不能为空";
        }
        articleMapper.create(article);
        return "发布成功";
    }

    public List<ArticleDTO> getArticleDTOS(){                  //获取文章传输beans
        List<Article> articles = articleMapper.getArticles();
        List<ArticleDTO> articleDTOS = new ArrayList<>();
        for (Article article:articles){
         User user = userMapper.getUserByUserName(article.getCreator()); //通过文章发布人用户名获得user对象
            ArticleDTO articleDTO = new ArticleDTO();
            BeanUtils.copyProperties(article,articleDTO);   //copy相同属性到另一个对象
            articleDTO.setUser(user);
            articleDTOS.add(articleDTO);
        }
        return articleDTOS;
    }

    public ArticleDTO getArticleDTObyId(Integer id) {
        Article article = articleMapper.getArticleById(id);
        User user = userMapper.getUserByUserName(article.getCreator());
        ArticleDTO articleDTO = new ArticleDTO();
        BeanUtils.copyProperties(article,articleDTO);
        articleDTO.setUser(user);
        return articleDTO;
    }


}
