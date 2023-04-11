package com.web.study.controller.lecture;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.lecture.LectureReqDto;
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
	
	@GetMapping("/lectures")
	public ResponseEntity<? extends ResponseDto> getLectures() {
		
		return ResponseEntity.ok().body(DataResponseDto.of(lectureService.getLectureAll()));
	}
	
	@GetMapping("/lecture/{id}")
	public ResponseEntity<? extends ResponseDto> getInstructorById(@PathVariable int id) {
		
		return ResponseEntity.ok().body(DataResponseDto.of(lectureService.findLectureById(id)));
	}
	
  // type은 int이기 때문에 필수자료형이 되어버림.
  // 파라메터가 String값으로 들여오기 때문에 값이 null 이면 type 값이 자동으로 0이 되지 않는다.
  // 만약 type을 필수자료형으로 사용하고 싶지 않다면 type과 searchValue를 객체로 빼줘야함!
	@GetMapping("/search/lectures")
	public ResponseEntity<? extends ResponseDto> searchLecture(int type, String searchValue) {
		return ResponseEntity.ok().body(DataResponseDto.of(lectureService.searchLecture(type, searchValue)));
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
