package com.bbu.pojo;

import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;

@Data
public class User {

    private String mail;
    private String pwd;
    private String userName;
    private String major;
    private String className;
    private String name;


}
