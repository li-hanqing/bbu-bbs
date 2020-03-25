package com.bbu.pojo;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;

public class User {

    private String mail;
    private String pwd;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
