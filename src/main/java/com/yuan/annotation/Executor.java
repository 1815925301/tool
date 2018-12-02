package com.yuan.annotation;

/**
 * FileName: Executor
 * Author:   yhl
 * Date:     2018/12/2 13:36
 * Description: ${DESCRIPTION}
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
public  @interface Executor {
    String taskClassName() default "";
    boolean isSingle() default true;
}
