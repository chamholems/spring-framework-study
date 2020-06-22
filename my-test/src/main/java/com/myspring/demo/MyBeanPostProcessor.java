package com.myspring.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	public MyBeanPostProcessor() {
		System.out.println("MyBeanPostProcessor构造方法调用了......");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if("myBean".equals(beanName)){
			System.out.println("MyBeanPostProcessor的before方法调用了......");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if("myBean".equals(beanName)){
			System.out.println("MyBeanPostProcessor的after方法调用了......");
		}
		return bean;
	}
}
