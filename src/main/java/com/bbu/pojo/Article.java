package com.bbu.pojo;

import lombok.Data;

@Data
public class Article {
        private int id;
        private String title;
        private String content;
        private  String tag;
        private Long gmtCreate;
        private Long gmtModified;
        private  String creator;
        private Integer viewCount;
        private Integer commentCount;
        private Integer likeCount;

}
