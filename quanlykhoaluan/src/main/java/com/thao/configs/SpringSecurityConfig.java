/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.text.SimpleDateFormat;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 *
 * @author Chung Vu
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan({
    "com.thao.repository",
    "com.thao.service",
    "com.thao.controllers",
    "com.thao.validator",
    "com.thao.utils"
})
@PropertySource("classpath:configs.properties")
@Order(2)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Resource
    private Environment env;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
    
    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
//                .failureUrl("/login?error");
//        http.logout().logoutSuccessUrl("/login");
//        http.exceptionHandling()
//                .accessDeniedPage("/login?accessDenied");

        http.authorizeRequests().antMatchers("/").permitAll()
        .antMatchers("/admin/**")
                .access("hasAuthority('GIAO_VU') or hasAuthority('ROLE_ADMIN')")
                .antMatchers("/giangvien/**").access("hasAuthority('GIAO_VU') or hasAuthority('ROLE_ADMIN') or hasAuthority('GIANG_VIEN')");
        http.csrf().disable();
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", this.env.getProperty("cloudinary.cloud_name"),
                        "api_key", this.env.getProperty("cloudinary.api_key"),
                        "api_secret", this.env.getProperty("cloudinary.api_secret"),
                        "secure", true));
        return cloudinary;
    }
//    @Bean
//    public GiangVienHuongDanWebAppValidator giangVienHuongDanValidator() {
//        Set<Validator> springValidators = new HashSet<>();
//        springValidators.add(new SoLuongKhoaLuanValidator());
//        GiangVienHuongDanWebAppValidator validator = new GiangVienHuongDanWebAppValidator();
//        validator.setSpringValidators(springValidators);
//        return validator;
//    }
    
//    @Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource m = new ResourceBundleMessageSource();
//        m.setBasename("messages");
//        return m;
//    }
    
    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean
                = new LocalValidatorFactoryBean();
//        bean.setValidationMessageSource(messageSource());
        return bean;
    }
    
    
}
