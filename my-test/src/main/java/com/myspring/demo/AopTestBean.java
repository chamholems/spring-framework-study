package com.myspring.demo;

import org.springframework.stereotype.Component;

@Component
public class AopTestBean {

	public void test() {
		System.out.println("业务代码!");
	}

}
