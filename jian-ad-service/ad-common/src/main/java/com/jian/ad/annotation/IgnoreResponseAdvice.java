package com.jian.ad.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE , ElementType.METHOD})  //可以写在类或者方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreResponseAdvice {
}
