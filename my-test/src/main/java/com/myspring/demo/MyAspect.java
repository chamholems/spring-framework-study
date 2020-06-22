package com.myspring.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	@Pointcut("execution(* com.myspring.*(..))")
	public void pointcut(){}

	@Before("pointcut()")
	public void before(){
		System.out.println("前置方法...");
	}
}
