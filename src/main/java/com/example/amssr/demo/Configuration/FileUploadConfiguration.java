package com.example.amssr.demo.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@PropertySource("classpath:ams.properties")
public class FileUploadConfiguration implements WebMvcConfigurer {
    @Value("${file.image.path}")
    String path;
    @Value("${file.image.clint}")
    String clint;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(path+ "**").addResourceLocations("file:"+clint);

    }

}
