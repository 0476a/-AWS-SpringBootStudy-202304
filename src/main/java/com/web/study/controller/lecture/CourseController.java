package com.web.study.controller.lecture;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.aop.annotation.CheckNameAspect;
import com.web.study.aop.annotation.ParamsAspect;
import com.web.study.aop.annotation.TimerAspect;
import com.web.study.aop.annotation.ValidAspect;
import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.course.CourseReqDto;
import com.web.study.dto.request.course.SearchCourseReqDto;
import com.web.study.exception.CustomException;
import com.web.study.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CourseController {
	
	private final CourseService courseService;
	
	@PostMapping("/course")
	public ResponseEntity<? extends ResponseDto> registerCourse(@RequestBody CourseReqDto courseReqDto) {
		
//		System.out.println(courseReqDto);
		courseService.registeCourse(courseReqDto);
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}
	
	@TimerAspect
	@CheckNameAspect
	@GetMapping("/courses")
	public ResponseEntity<? extends ResponseDto> getCourseAll() {
		
//		if(1 == 1) {
//			throw new CustomException("예외 만들기");
//		}
		
		return ResponseEntity.ok().body(DataResponseDto.of(courseService.getCourseAll()));
	}
	
	@ValidAspect
	@ParamsAspect
	@GetMapping("/search/courses")
	public ResponseEntity<? extends ResponseDto> searchCourse(@Valid SearchCourseReqDto searchCourseReqDto, BindingResult bindingResult) {
		
//		if(bindingResult.hasErrors()) {
//			Map<String, String> erroMap = new HashMap<>();
//			
//			bindingResult.getFieldErrors().forEach(error -> {
//				erroMap.put(error.getField(), error.getDefaultMessage());
//			});
//			
//			throw new CustomException("유효성 검사 실패", erroMap);
//		}
		
		return ResponseEntity.ok().body(
				DataResponseDto.of(
						courseService.searchCourse(
								searchCourseReqDto.getType(),
								searchCourseReqDto.getSearchValue())));
		
//		Map<String, String> errorMap = new HashMap<>();
//		
//		if(type < 1 || type > 3) {
//			errorMap.put("type", "type은 1에서 3의 사이값만 사용할 수 있습니다.");
//		}
//		
//		if(searchValue == null) {
//			errorMap.put("searchValue", "searchValue는 필수입니다.");
//		}else {
//			if(searchValue.isBlank()) {
//				errorMap.put("searchValue", "searchValue는 공백일 수 없습니다.");
//			}
//		}
//		
//		if(!errorMap.isEmpty()) {
//			throw new CustomException("유효성 검사 실패", errorMap);
//		}
//		
//		return ResponseEntity.ok().body(DataResponseDto.of(courseService.searchCourse(type, searchValue)));
	}
}
