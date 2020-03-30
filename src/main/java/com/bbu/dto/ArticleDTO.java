package com.bbu.dto;

import com.bbu.model.User;
import lombok.Data;

@Data
public class ArticleDTO {
    private int id;
    private String title;
    private String content;
    private  String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private String creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
