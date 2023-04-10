package com.web.study.controller.lecture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.course.CourseReqDto;
import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.request.lecturer.LecturerReqDto;
import com.web.study.dto.request.student.StudentReqDto;
import com.web.study.service.LectureService;

import lombok.RequiredArgsConstructor;

// Controller 또는 API 라고 적어주면됨.
@RestController
@RequiredArgsConstructor
public class LectureController {

	// 만약 lectureService를 autowired를 해서 원하는 구현문을 넣어준다.
	private final LectureService lectureService;
	
	// Create
	@PostMapping("/lecture")
	public ResponseEntity<? extends ResponseDto> registerLecture(@RequestBody LectureReqDto lectureReqDto) {
		
		lectureService.registeLecture(lectureReqDto);
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}

	// Read
	public ResponseEntity<? extends ResponseDto> get() {
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}
	
	// Update
	public ResponseEntity<? extends ResponseDto> modify() {
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}
	
	// Delete
	public ResponseEntity<? extends ResponseDto> remove() {
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}
}
