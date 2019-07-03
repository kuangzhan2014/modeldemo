package com.maitianer.modeldemo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zhou
 * @Date: 2019/07/03 11:15
 */
@Configuration
@MapperScan("com.maitianer.modeldemo.mapper")
public class MybatisPlusConfig {
    /**
     * @Description : mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * @Description : druid注入
     */
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid." )
//    public DataSource dataSource() {
//        return DruidDataSourceBuilder
//                .create()
//                .build();
//    }
}
