/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.validator;

import com.thao.pojo.GiangVienHuongDanKhoaLuan;
import java.util.HashSet;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Chung Vu
 */
@Component
public class GiangVienHuongDanWebAppValidator implements Validator {
    @Autowired
    private javax.validation.Validator beanValidator;

    private Set<Validator> springValidators = new HashSet<>();

    @Override
    public boolean supports(Class<?> clazz) {
        return GiangVienHuongDanKhoaLuan.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Set<ConstraintViolation<Object>> constraintViolations = beanValidator.validate(target);
        for (ConstraintViolation<Object> obj : constraintViolations) {
            errors.rejectValue(obj.getPropertyPath().toString(), obj.getMessageTemplate(), obj.getMessage());
        }
        for (Validator obj : springValidators) {
            obj.validate(target, errors);
        }
    }

    public void setSpringValidators(
            Set<Validator> springValidators) {
        this.springValidators = springValidators;
    }
}
