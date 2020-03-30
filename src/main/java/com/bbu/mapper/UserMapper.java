package com.bbu.mapper;

import com.bbu.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper         //表示mybatis的mapper类
@Repository     //表示spring数据库操纵层的一个组件
public interface UserMapper {

    //通过邮箱账号查找返回User对象
    @Select("select *from user where mail = #{mail}")
    public User getUserByUserMail(String mail);

    //通过用户名查找返回对象
    @Select("select *from user where user_name = #{userName}")
    public User getUserByUserName(String userName);

    //插入一条用户记录
    @Insert("insert into user(user_name,mail,pwd) values(#{userName},#{mail},#{pwd})")
    public int insert(User user);

//    @Update("update user set pwd = #{pwd} where mail = #{mail}")
//    public int updateUserPwdByUserMail(String mail,String pwd);

}
