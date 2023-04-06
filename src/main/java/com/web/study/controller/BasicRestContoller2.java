package com.web.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.BasicTestDto2;

@RestController
public class BasicRestContoller2 {
	
	// 책이름으로 값 찾아서 찾은 값 답장 해주기
	@GetMapping("/book/read")
	public ResponseEntity<? extends ResponseDto> read(String bookName) {
		
		return ResponseEntity.ok().body(DataResponseDto.of(bookName));
	}
	
	// 책이름, 저자, 가격을 찾아서 찾은 값 답장 해주기
	@GetMapping("/book/reads")
	public ResponseEntity<? extends ResponseDto> reads(String bookName, String author, int price) {
		
		String saleBook = "책이름:" + bookName + "저자:" + author + "책가격:" + price;
		
		return ResponseEntity.ok().body(DataResponseDto.of(saleBook));
	}
	
	

	// 책정보로 값 찾아서 찾은 값 답장 해주기
	@GetMapping("/book/read/all")
	public ResponseEntity<? extends ResponseDto> readAll(BasicTestDto2 basicTestDto2) {
		
		String bookInfo = basicTestDto2.getBookId() + ":" + basicTestDto2.getBookName();
		
		return ResponseEntity.ok().body(DataResponseDto.of(bookInfo));
	}
	
	// 음식과 음식 아이디를 넣어서 pathvariable로 값 찾아서 답장 해주기
	@GetMapping("/food/read/{foodId}")
	public ResponseEntity<? extends ResponseDto> read2(@PathVariable int foodId) {
		Map<Integer, String> foodMap = new HashMap<>();
		foodMap.put(1, "육계장");
		foodMap.put(2, "갈비탕");
		foodMap.put(3, "라면");
		foodMap.put(4, "순두부찌개");
		foodMap.put(5, "돈까스");
		return ResponseEntity.ok().body(DataResponseDto.of(foodMap.get(foodId)));
	}
	
	// post요청으로 값 추가해주기 form 사용
	@PostMapping("/book/create/form")
	public ResponseEntity<? extends ResponseDto> createForm(BasicTestDto2 basicTestDto2) {
		
		return ResponseEntity.created(null).body(DataResponseDto.of(basicTestDto2));
	}
	
	// post요청으로 값 추가하기 json 사용
	@PostMapping("book/create/json")
	public ResponseEntity<? extends ResponseDto> createJson(@RequestBody BasicTestDto2 basicTestDto2) {
		
		return ResponseEntity.created(null).body(DataResponseDto.of(basicTestDto2));
	}
	
	
	
}
