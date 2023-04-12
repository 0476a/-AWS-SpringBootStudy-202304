package com.web.study.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 실행중에 어노테이션을 지정시켜 주겠다는 뜻
@Retention(RetentionPolicy.RUNTIME)
// 어노테이션을 달 수 있는 녀석을 지정해주는 것(메소드에만 달 수 있다.)
@Target({ElementType.METHOD})
public @interface TimerAspect {

}
