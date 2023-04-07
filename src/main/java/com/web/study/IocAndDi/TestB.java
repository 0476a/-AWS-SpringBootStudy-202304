package com.web.study.IocAndDi;

import org.springframework.stereotype.Component;

// 해당 컴포넌트의 이름을 t2로 지정해 놓은 것이다.
@Component("t2")
public class TestB implements Test{

	@Override
	public void printTest() {
		System.out.println("TestB 클래스!!!");
	}
}
