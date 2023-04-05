package com.web.study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ErrorResponseDto;
import com.web.study.dto.ResponseDto;

@RestController
public class BasicController {
	
	// 응답 인터페이스라고 함! 인터페이스를 맞춰 줘야함! (항상 이런 형식으로 보내줌.)
	// 내용만 바뀜. -> 나중에 프론트엔드가 보기 편함.
	@GetMapping("/view/test")
	public ResponseEntity<? extends ResponseDto> view() {
		
		List<String> strList = new ArrayList<>();
		strList.add("a");
		strList.add("b");
		strList.add("c");
		strList.add("d");
		strList.add("e");
		
		if(strList.contains("e")) {
			try {
				throw new RuntimeException("오류났어!!!!");
			} catch (Exception e) {
				// internalServerError 는 500 에러이다. (RuntimeException에는 500에러를 준다.)
				return ResponseEntity.internalServerError().body(ErrorResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, e));
			}
		}
		
		
		return ResponseEntity.ok().body(DataResponseDto.of(strList));
	}
	
}
