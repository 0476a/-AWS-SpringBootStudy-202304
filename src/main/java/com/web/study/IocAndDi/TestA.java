package com.web.study.IocAndDi;

import org.springframework.stereotype.Component;

//해당 컴포넌트의 이름을 t1으로 지정해 놓은 것이다.
@Component("t1")
public class TestA implements Test{
	
	@Override
	public void printTest() {
		System.out.println("TestA 클래스!!!");
	}
}
