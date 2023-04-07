package com.web.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyApplication {
	
	public static void main(String[] args) {
		// run 이라는 메소드가 없는데 불러오고 있음.
		// 처음부터 만들어져있으니깐 쓰는거 더 파고 들고 싶으면 나중에 이해!
		SpringApplication.run(StudyApplication.class, args);
//		iocAndDiTest();
	}
	
//	public static void iocAndDiTest() {
//		// iocTest가 생성될때 TestA 라는 객체를 생성해서 넣어준다.
//		// 이렇게 조립하는 행위를 ioc에서 해준다.
//		// Inversion Of Control 제어의 역전
//		// 제어를 개발자가 아닌 프로그램(spring)이 함.
//		// spring이 우리가 만든 부품들을 제어함.
//		IocTest iocTest = new IocTest(new TestB());
//		iocTest.run();
//	}

}
