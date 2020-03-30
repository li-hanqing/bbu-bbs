package com.bbu.service;

import com.bbu.mapper.UserMapper;
import com.bbu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public Boolean login(String mail,String pwd){
       User user = userMapper.getUserByUserMail(mail);
       if (user!=null && user.getPwd().equals(pwd))
           return true;
       else
           return false;
    }
    //通过邮箱获得user对象
    public User getUser(String mail){
       return userMapper.getUserByUserMail(mail);
    }
    public boolean regist(User user){
        if (userMapper.getUserByUserMail(user.getMail())!=null&&userMapper.getUserByUserName(user.getUserName())!=null) {  //如果账号存在注册失败
            return false;
        }
        else {
            if (userMapper.insert(user) == 1)
                return true;
            else
                return false;
        }

    }

}
