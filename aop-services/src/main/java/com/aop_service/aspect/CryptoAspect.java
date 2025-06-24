// CryptoAspect.java
package com.aop_service.aspect;

import com.aop_service.annotations.Decrypt;
import com.aop_service.annotations.Encrypt;
import com.aop_service.utils.CryptoUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Slf4j
@Aspect
@Component
public class CryptoAspect {

    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void encryptFields(JoinPoint joinPoint) throws IllegalAccessException {
        for (Object arg : joinPoint.getArgs()) {
            processFields(arg, Encrypt.class, true);
        }
    }

    @AfterReturning(pointcut = "execution(* com..*Controller.*(..))", returning = "result")
    public void decryptFields(JoinPoint joinPoint, Object result) throws IllegalAccessException {
        if (result != null) {
            processFields(result, Decrypt.class, false);
        }
    }

    private void processFields(Object obj, Class annotation, boolean isEncrypt) throws IllegalAccessException {
        if (obj == null) return;

        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(annotation)) {
                field.setAccessible(true);
                Object value = field.get(obj);
                if (value instanceof String str) {
                    String transformed = isEncrypt ? CryptoUtil.encrypt(str) : CryptoUtil.decrypt(str);
                    field.set(obj, transformed);
                }
            }
        }
    }
}
