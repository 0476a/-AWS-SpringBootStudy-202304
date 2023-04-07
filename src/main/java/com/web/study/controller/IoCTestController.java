package com.web.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.IocAndDi.IocTest;
import com.web.study.IocAndDi.IocTest2;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class IoCTestController {
	
	// 이 공정을 어노 테이션으로 만들어 놓은 것이 autowired이다.
	// 여기서 iocTest에 final을 넣어줘야 필수로 값을 넣어주게 됨.
	// 변수의 양이 많아지면 이 방법 사용하는 것이 좋다.
	private final IocTest iocTest;
	private final IocTest2 iocTest2;
	
	// 어노테이션으로 RequiredArgsConstructor를 사용해줌.
//	public IoCTestController(IocTest iocTest, IocTest2 iocTest2) {
//		this.iocTest = iocTest;
//		this.iocTest2 = iocTest2;
//	}
	
	// 객체가 하나만 필요할때 해당 방법을 사용함! 2개 이상 사용시 변수 위에 어노테이션을 다 달아줘야함!
//	@Autowired
//	private IocTest iocTest;
//	@Autowired
//	private IocTest2 iocTest2;
	
	@GetMapping("/ioc/test")
	public Object test() {
		iocTest.run();
		iocTest2.run();
		return null;
	}
}
