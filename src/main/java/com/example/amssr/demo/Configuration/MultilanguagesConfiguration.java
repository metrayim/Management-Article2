package com.example.amssr.demo.Configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.websocket.Session;
import java.util.Locale;

@Configuration
public class MultilanguagesConfiguration implements WebMvcConfigurer {
    @Bean
    LocaleResolver localeResolver(){
        SessionLocaleResolver slr=new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("kh"));
        return slr;
    }
    @Bean
    LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor lci=new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(this.localeChangeInterceptor());
    }
//    @Bean
//    MessageSource messageSource(){
//        ResourceBundleMessageSource rbms=new ResourceBundleMessageSource();
//        rbms.setBasename("lang/messages");
//        return rbms;
//    }
}
