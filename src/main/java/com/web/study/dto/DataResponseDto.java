package com.web.study.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class DataResponseDto<T> extends ResponseDto{

	private final T data;
	
	private DataResponseDto(T data) {
		//           값이 200을 의미함.
		super(true, HttpStatus.OK.value(), "Successfully");
		this.data = data;
	}
	
	private DataResponseDto(T data, String message) {
		super(true, HttpStatus.OK.value(), message);
		this.data = data;
	}
	
	
	// of는 메소드 명이다.
	public static <T> DataResponseDto<T> of(T data) {
		return new DataResponseDto<T>(data);
	}
	
	// static에 제네릭 쓰고 싶으면 static <T>를 해줘야함!
	public static <T> DataResponseDto<T> of(T data, String message) {
		return new DataResponseDto<T>(data, message);
	}
	
	public static <T> DataResponseDto<T> empty() {
		return new DataResponseDto<T>(null);
	}

}
