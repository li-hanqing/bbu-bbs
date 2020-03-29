package com.bbu.mapper;

import com.bbu.model.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    @Select("select * from article where creator = #{userName}")
    List<Article> getArticlesByCreator(String userName);

    @Update("update article set title = #{title}, content = #{content}, tag = #{tag}, gmt_modified = #{gmtModified} where id = #{id}")
    public void updateArticleById(Article article);
}
