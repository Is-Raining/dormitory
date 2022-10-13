package com.example.dormitory.config;

import com.example.dormitory.entity.Student;
import com.example.dormitory.service.StudentService;
import org.apache.catalina.realm.AuthenticatedUserRealm;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//自定义realm
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private StudentService studentService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("授权");
        return null;
    }

    //自定义认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //1获取用户身份信息
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        //连接数据库
        Student student = studentService.queryUserByName(userToken.getUsername());

        if(student==null){
            return null;
        }

        //2调用业务层获取用户信息（数据库）

        //3非空判断，将数据封装返回
        System.out.println("认证");
        //密码认证，shiro做
        return new SimpleAuthenticationInfo(student,student.getStudentPassword(),"");
    }
    //授权


}
