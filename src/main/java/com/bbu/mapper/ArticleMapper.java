package com.bbu.mapper;

import com.bbu.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ArticleMapper {

    @Insert("insert into article(title,content,gmt_create,gmt_modified,tag) values(#{title},#{content},#{gmtCreate},#{gmtModified},#{tag})")
    public void create(Article article);
}
