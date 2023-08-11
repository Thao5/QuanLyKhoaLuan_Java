/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.configs;

import com.thao.validator.GiangVienHuongDanWebAppValidator;
import com.thao.formatters.KhoaLuanFormatter;
import com.thao.formatters.NguoiDungFormatter;
import com.thao.validator.SoLuongKhoaLuanValidator;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Chung Vu
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan({
    "com.thao.repository",
    "com.thao.service",
    "com.thao.controllers",
    "com.thao.validator"
})
public class WebApplicationContextConfig implements WebMvcConfigurer {
    
    @Autowired
    private SoLuongKhoaLuanValidator soLuongKhoaLuanValidator;
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

//    @Bean
//    public InternalResourceViewResolver getInternalResourceViewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setViewClass(JstlView.class);
//        resolver.setPrefix("/WEB-INF/pages/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new KhoaLuanFormatter());
        registry.addFormatter(new NguoiDungFormatter());
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource m = new ResourceBundleMessageSource();
        m.setBasename("messages");
        return m;
    }

    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean
                = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

    @Bean
//    @DependsOn("giangVienHuongDanKhoaLuanRepository")
//    @Order(Ordered.LOWEST_PRECEDENCE)
    public GiangVienHuongDanWebAppValidator giangVienHuongDanValidator() {
        Set<Validator> springValidators = new HashSet<>();
        springValidators.add(soLuongKhoaLuanValidator);
        GiangVienHuongDanWebAppValidator validator = new GiangVienHuongDanWebAppValidator();
        validator.setSpringValidators(springValidators);
        return validator;
    }
}
