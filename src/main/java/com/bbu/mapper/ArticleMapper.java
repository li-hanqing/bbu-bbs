package com.bbu.mapper;

import com.bbu.model.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {

    @Insert("insert into article(title,content,gmt_create,gmt_modified,tag,creator) values(#{title},#{content},#{gmtCreate},#{gmtModified},#{tag},#{creator})")
    public void create(Article article);

    @Select("select * from article")
    public List<Article> getArticles();
    @Select("select * from article where id = #{id}")
    public Article getArticleById(Integer id);
}
