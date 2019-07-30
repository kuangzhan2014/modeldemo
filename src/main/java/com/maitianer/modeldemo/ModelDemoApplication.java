package com.maitianer.modeldemo;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.maitianer.common.spring.SpringContextHolder;
import com.maitianer.modeldemo.utils.CustomUtilsDialect;
import com.maitianer.modeldemo.utils.DictUtils;
import com.maitianer.modeldemo.utils.GlobalParamUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class ModelDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelDemoApplication.class, args);
        DictUtils.loadDictData();
        GlobalParamUtils.loadGlobalParams();
    }

    @Bean
    public LocaleResolver localeResolver() {
        FixedLocaleResolver slr = new FixedLocaleResolver();
        slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return slr;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:language/message");
        messageSource.setUseCodeAsDefaultMessage(false);
        messageSource.setCacheSeconds(10); //reload messages every 10 seconds
        return messageSource;
    }
//    @Bean(name = "shiroDialect")
//    public ShiroDialect shiroDialect(){
//        return new ShiroDialect();
//    }

    @Bean
    @ConditionalOnMissingBean
    public CustomUtilsDialect customUtilsDialect() {
        return new CustomUtilsDialect();
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }
}
