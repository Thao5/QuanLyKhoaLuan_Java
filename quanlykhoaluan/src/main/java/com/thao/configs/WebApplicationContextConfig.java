/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.configs;

import com.thao.formatters.GiangVienThuocHoiDongFormatter;
import com.thao.formatters.HoiDongBaoVeKhoaLuanFormatter;
import com.thao.validator.GiangVienHuongDanWebAppValidator;
import com.thao.formatters.KhoaLuanFormatter;
import com.thao.formatters.NguoiDungFormatter;
import com.thao.formatters.TieuChiFormatter;
import com.thao.validator.GiangVienThuocHoiDongValidator;
import com.thao.validator.GiangVienThuocHoiDongWebAppValidator;
import com.thao.validator.NguoiDungValidator;
import com.thao.validator.NguoiDungWebAppValidator;
import com.thao.validator.SoLuongKhoaLuanValidator;
import com.thao.validator.ThongTinGanKhoaLuanChoHoiDongValidator;
import com.thao.validator.ThongTinGanKhoaLuanChoHoiDongWebAppValidator;
import com.thao.validator.ThongTinGiangVienChamDiemValidator;
import com.thao.validator.ThongTinGiangVienChamDiemWebAppValidator;
import com.thao.validator.ThongTinThanhLapHoiDongValidator;
import com.thao.validator.ThongTinThanhLapHoiDongWebAppValidator;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
    "com.thao.validator",
    "com.thao.utils"
})
public class WebApplicationContextConfig implements WebMvcConfigurer {

    @Autowired
    private SoLuongKhoaLuanValidator soLuongKhoaLuanValidator;

    @Autowired
    private NguoiDungValidator nguoiDungValidator;
    
    @Autowired
    private ThongTinThanhLapHoiDongValidator thongTinThanhLapHoiDongValidator;
    
    @Autowired
    private ThongTinGanKhoaLuanChoHoiDongValidator thongTinGanKhoaLuanChoHoiDongValidator;
    
    @Autowired
    private ThongTinGiangVienChamDiemValidator thongTinGiangVienChamDiemValidator;
    
    @Autowired
    private GiangVienThuocHoiDongValidator giangVienThuocHoiDongValidator;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/api/**")
//            .allowedOrigins("http://localhost:3000")
//            .allowedMethods("GET", "POST", "OPTIONS", "PUT");
//    }
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
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/WEB-INF/resources/css/");
        registry.addResourceHandler("/img/**")
                .addResourceLocations("/WEB-INF/resources/assets/img/");
        registry.addResourceHandler("/demo/**")
                .addResourceLocations("/WEB-INF/resources/assets/demo/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/WEB-INF/resources/js/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new KhoaLuanFormatter());
        registry.addFormatter(new NguoiDungFormatter());
        registry.addFormatter(new HoiDongBaoVeKhoaLuanFormatter());
        registry.addFormatter(new TieuChiFormatter());
        registry.addFormatter(new GiangVienThuocHoiDongFormatter());
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

    @Bean
    public NguoiDungWebAppValidator nguoiDungValids() {
        Set<Validator> springValidators = new HashSet<>();
        springValidators.add(nguoiDungValidator);
        NguoiDungWebAppValidator validator = new NguoiDungWebAppValidator();
        validator.setSpringValidators(springValidators);
        return validator;
    }
    
    @Bean
    public ThongTinThanhLapHoiDongWebAppValidator thongTinThanhLapHoiDongWebAppValidator(){
        Set<Validator> springValidators = new HashSet<>();
        springValidators.add(thongTinThanhLapHoiDongValidator);
        ThongTinThanhLapHoiDongWebAppValidator validator = new ThongTinThanhLapHoiDongWebAppValidator();
        validator.setSpringValidators(springValidators);
        return validator;
    }
    
    @Bean
    public ThongTinGanKhoaLuanChoHoiDongWebAppValidator thongTinGanKhoaLuanChoHoiDongWebAppValidator(){
        Set<Validator> springValidators = new HashSet<>();
        springValidators.add(thongTinGanKhoaLuanChoHoiDongValidator);
        ThongTinGanKhoaLuanChoHoiDongWebAppValidator validator = new ThongTinGanKhoaLuanChoHoiDongWebAppValidator();
        validator.setSpringValidators(springValidators);
        return validator;
    }
    
    @Bean
    public ThongTinGiangVienChamDiemWebAppValidator thongTinGiangVienChamDiemWebAppValidator(){
        Set<Validator> springValidators = new HashSet<>();
        springValidators.add(thongTinGiangVienChamDiemValidator);
        ThongTinGiangVienChamDiemWebAppValidator validator = new ThongTinGiangVienChamDiemWebAppValidator();
        validator.setSpringValidators(springValidators);
        return validator;
    }
    
    @Bean
    public GiangVienThuocHoiDongWebAppValidator giangVienThuocHoiDongWebAppValidator(){
        Set<Validator> springValidators = new HashSet<>();
        springValidators.add(giangVienThuocHoiDongValidator);
        GiangVienThuocHoiDongWebAppValidator validator = new GiangVienThuocHoiDongWebAppValidator();
        validator.setSpringValidators(springValidators);
        return validator;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }
}
