package com.bbu.service;

import com.bbu.mapper.UserMapper;
import com.bbu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    final
    UserMapper userMapper;
    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Boolean login(String mail,String pwd){
       User user = userMapper.getUserByUserMail(mail);
       if (user.getPwd().equals(pwd))
           return true;
       else
           return false;
    }

    public boolean regist(User user){
        if (userMapper.getUserByUserMail(user.getMail())!=null) {  //如果账号存在注册失败
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
