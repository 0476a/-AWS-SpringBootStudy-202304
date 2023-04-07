package com.web.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.web.study.IocAndDi.TestC;

// config는 bean을 등록해주는 클래스이다.
// 외부라이브러리를 생성해서 사용해야할 때 씀.
// 외부 라이브러리에 클래스에는 직접적으로 component가 걸리지 않으므로
// 여기서 생성해줘서 bean에다가 등록해준다.
// bean을 등록하고 싶으면 config에 넣어준다.
// 여러개의 bean들을 관리할 수 있음.
@Configuration
public class BeanConfig {
	
	@Bean
	public TestC testC() {
		return new TestC();
	}
}
