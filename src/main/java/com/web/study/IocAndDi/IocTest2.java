package com.web.study.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class IocTest2 {

	// 컴포넌트에서 지정한 이름을 써주면 해당 컴포넌트를 찾아서 넣어줌.
	@Qualifier("testC")
	@Autowired
	private Test test;
	
	// 의존성 주입 (di) 외부에서 Test를 주입해주는 것. 해당 코드를 바꿀 필요가 없다. (수정이 불필요함!)
	// 매개변수로 받는 Test의 값에 따라 내용이 바뀌게 됨.
//	public IocTest(Test test) {
//		this.test = test;
//	}
	
	public void run() {
		test.printTest();
		System.out.println("IoCTest2 출력!");
	}
}
