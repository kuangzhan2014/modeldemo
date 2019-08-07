package com.maitianer.sms;

import com.maitianer.sms.core.NetEaseSmsClient;
import com.maitianer.sms.core.SmsClient;
import com.maitianer.sms.core.YunFengSmsClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Mr.Zhang
 * @Date: 2018-12-18 17:53
 */
@Configuration
@EnableConfigurationProperties(SmsProperties.class)
@ConditionalOnProperty(prefix = "sms", name = {"platform", "app-key", "app-secret"})
public class SmsAutoConfiguration {

    @Bean
    public SmsClient smsClient(SmsProperties properties) {
        switch (properties.getPlatform()) {
            case ZhuanXinYun:
                return new YunFengSmsClient(properties.getAppKey(), properties.getAppSecret(), properties.getSignName());
            case NetEase:
                return new NetEaseSmsClient(properties.getAppKey(), properties.getAppSecret(), properties.getSignName());
        }
        return null;
    }
}
