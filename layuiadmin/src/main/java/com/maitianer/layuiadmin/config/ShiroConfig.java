package com.maitianer.layuiadmin.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.maitianer.layuiadmin.core.security.MemberRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zhou
 * @Date: 2019/06/26 14:53
 */
@Configuration
public class ShiroConfig {
    //Shiro用starter方式优雅整合到SpringBoot中
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/favicon.ico", "anon");
        chainDefinition.addPathDefinition("/static/**", "anon");
        chainDefinition.addPathDefinition("/user/logout", "logout");
        // 注册，可匿名访问
        chainDefinition.addPathDefinition("/user/reg", "anon");
        chainDefinition.addPathDefinition("/user/forget", "anon");


        // 图片访问
//        chainDefinition.addPathDefinition("/api/**", "anon");


        // all other paths require a logged in user
        chainDefinition.addPathDefinition("/**", "authc");
        return chainDefinition;
    }

    @Bean
    public Realm realm() {
        return new MemberRealm();
    }


//    /**
//     * 1. 创建ShiroFilterFactoryBean;
//     */
//    @Bean(name="shiroFilterFactoryBean")
//    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//
//        //设置安全管理器
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//
//        //添加shiro的过滤器
//        /**
//         *         shiro的内置过滤器：可以实现权限的相关拦截
//         *         常用的过滤器：
//         *         1.anon：无需认证（登陆即可访问）
//         *         2.authc：必须认证才可以访问
//         *         3.user：如果使用remanberMe的功能就可以直接访问
//         *         4.perms：该资源必须得到资源权限才可以访问
//         *         5.role：该资源必须得到角色权限才可以访问
//         */
//        Map<String,String> filterMap =new LinkedHashMap<String, String>();
////        filterMap.put("/add","authc");
////        filterMap.put("/update","authc");
//        filterMap.put("/druid","anon");
////        filterMap.put("/testThymeleaf","anon");
//        filterMap.put("/user/login","anon");
//        //授权过滤器,当前授权被拦截自动跳转到未授权页面
//        filterMap.put("/add","perms[user:add]");
//        filterMap.put("/update","perms[user:update]");
//
//        filterMap.put("/*","authc");
//
//
//        //修改调整的登录页面
//        shiroFilterFactoryBean.setLoginUrl("/user/login");
//        //设置未授权提示页面
//        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
//
//
//        shiroFilterFactoryBean.setFilterChainDefinitionMap((filterMap));
//
//
////        Map filterMap = new HashMap();
////
////        //必须登陆才可以访问
////        //设置哪些页面必须授权后才可以登陆
////        filterMap.put("/user/student","perms[2]");//学生页面
////        filterMap.put("/user/teacher","perms[1]");//老师页面
////        filterMap.put("/user/index","authc");//首页
////
////        //被拦截后跳转登陆页面
////        shiroFilterFactoryBean.setLoginUrl("/user/login ");
////        //未授权跳转页面
////        shiroFilterFactoryBean.setUnauthorizedUrl("/user/unAuth");
////        //将filterMap中的url和相关权限交给shiro框架管理
////        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
//
//        return shiroFilterFactoryBean;
//    }
//    /**
//     * 2. 创建DefaultWebSecurityManager;
//     */
//    @Bean(name = "securityManager")
//    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm)
//    {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//
//        //关联realm
//        securityManager.setRealm(userRealm);
//
//        return securityManager;
//    }
//    /**
//     * 3. 创建Realm;
//     */
//    @Bean(name = "userRealm")
//    public UserRealm getRealm() {
//        return new UserRealm();
//    }


    /**
     * 配置shiroDialect，用于thymeleaf和shiro标签配合使用
     */
    @Bean(name = "shiroDialect")
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }

}
