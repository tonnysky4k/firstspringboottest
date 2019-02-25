package com.tonny.first.utils;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class TonnyMvcConfig implements WebMvcConfigurer {
    @Bean
    public LocaleResolver localeResolver()
    {
        return new TonnyLocalResolver();
    }
   // @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/").setViewName("login2");
       registry.addViewController("/login").setViewName("login2");
    }
}
