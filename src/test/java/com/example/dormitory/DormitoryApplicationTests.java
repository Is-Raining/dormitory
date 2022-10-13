package com.example.dormitory;

import com.example.dormitory.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DormitoryApplicationTests {

    @Autowired
    StudentServiceImpl userService;
    @Test
    void contextLoads() {
        System.out.println(userService.queryUserByName("2201210001"));
    }
}
