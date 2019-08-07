package com.maitianer.pay.alipay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * User: Leo
 * Date: 2018/10/2 9:03 PM
 */
@Configuration
@EnableConfigurationProperties(AlipayProperties.class)
@ConditionalOnProperty(prefix = "alipay", name = {"app-id"})
public class AlipayAutoConfiguration {

    @Autowired
    private AlipayProperties alipayProperties;


}
