package com.bbu;

import com.bbu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class ProjectApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(userMapper.getUserByUserMail("123@qq.com").getPwd());

    }

}
