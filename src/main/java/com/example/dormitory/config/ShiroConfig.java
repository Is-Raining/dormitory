package com.example.dormitory.config;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;
@Configuration
public class ShiroConfig {
    //创建realm对象，需要自定义
    @Autowired
    private UserRealm myRealm;
    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //过滤器
        /*
        anon:
        无需认证就可以访问
        authc:
        必须认证了才能让问
        user:
        必须棚有记住我功能才能用
        perms:
        拥有对某个资源的权限才能访问：
        role:
        拥有某个角色权限才能访问
        */

        //拦截
        Map<String,String> filterMap = new LinkedHashMap<>();


        //权限
        filterMap.put("/personal_infor","perms[user:add]");
        filterMap.put("/userInfo","authc");//用户信息需要登录
        filterMap.put("/buildings","authc");//查询楼列表需要登录
        filterMap.put("/login","anon");
        //filterMap.put("/user/update","authc");
        bean.setFilterChainDefinitionMap(filterMap);
         //设置登录的请求
        bean.setLoginUrl("/Hello");

        bean.setUnauthorizedUrl("/Hello");
        return bean;

    }


    //DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(){
        //1创建defaultWebSecurityManager对象
        DefaultWebSecurityManager manager =new DefaultWebSecurityManager();
        //2创建加密对象，设置相关属性
        //3将加密对象存储到myReaLm中
        //4将myReaLm存入defaultWebSecurityManager对象
        manager.setRealm(myRealm);
        //5返回
        return manager;
    }







}
