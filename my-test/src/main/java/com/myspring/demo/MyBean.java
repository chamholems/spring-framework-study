package com.myspring.demo;

import org.springframework.beans.factory.InitializingBean;

public class MyBean implements InitializingBean {

	private int id;

	private String name;

	public MyBean() {
		System.out.println("构造器执行了......");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet执行了......");
	}
}
