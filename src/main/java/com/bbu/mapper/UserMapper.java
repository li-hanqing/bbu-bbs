package com.bbu.mapper;

import com.bbu.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper         //表示mybatis的mapper类
@Repository     //表示spring数据库操纵层的一个组件
public interface UserMapper {

    @Select("select *from user where mail = #{mail}")
    public User getUserByUserMail(String mail);


    @Insert("insert into user(mail,pwd) values(#{mail},#{pwd})")
    public int insert(User user);

    @Update("update user set pwd = #{pwd} where mail = #{mail}")
    public int updateUserPwdByUserMail(String mail,String pwd);

}
