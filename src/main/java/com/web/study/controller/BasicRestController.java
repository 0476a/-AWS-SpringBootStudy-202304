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
import com.web.study.dto.request.BasicTestDto;

import lombok.Data;

// 어노테이션 Data가 꼭 있어야 함. setter가 존재 해야함.
//  -> 객체를 생성해야하기 때문이다.
//@Data
//class Params {
//	private int age;
//	private String name;
//}

@RestController
public class BasicRestController {

	// GET 요청의 param을 처리하는 방법
//	@GetMapping("/read")
//	public ResponseEntity<? extends ResponseDto> read(
//			@RequestParam("age") int userAge,
//			@RequestParam("name") String userName) {
//		
//		String userInfo = userName + "(" + userAge + ")";
//		
//		return ResponseEntity.ok().body(DataResponseDto.of(userInfo));
//	}
	
	// GET 요청의 param을 처리하는 방법
	// RequestParam을 생략해주기 위해서 키값을 변수명으로 해주면 생략이 가능하다.
	// GET이랑 POST만 가능함
	@GetMapping("/read")
	public ResponseEntity<? extends ResponseDto> read(BasicTestDto basicTestDto) {
		
		String userInfo = basicTestDto.getName() + "(" + basicTestDto.getAge() + ")";
		
		return ResponseEntity.badRequest().body(DataResponseDto.of(userInfo));
	}
	
//	// 경로 자체에 값을 넣어주는 방식인 pathVariable을 사용함.
//	@GetMapping("/read2/{id}")
//	public ResponseEntity<? extends ResponseDto> read2(@PathVariable("id") int userId) {
//		Map<Integer, String> userMap = new HashMap<>();
//		
//		userMap.put(1, "김삼겹");
//		userMap.put(2, "김사겹");
//		userMap.put(3, "김오겹");
//		userMap.put(4, "김육겹");
//		userMap.put(5, "김칠겹");
//		
//		
//		return ResponseEntity.ok().body(DataResponseDto.of(userMap.get(userId)));
//	}
	
	// 경로 자체에 값을 넣어주는 방식인 pathVariable을 사용함.
	// PathVariable은 생략하지 못하고 키값만 같게 해주고 생략해줘도 됨.
	// GET이랑 POST, PUT까지 사용 가능함!
	// 여기서 PUT은 요청때 JSON으로만 받을 수 있음.
	@GetMapping("/read2/{id}")
	public ResponseEntity<? extends ResponseDto> read2(@PathVariable int id) {
		Map<Integer, String> userMap = new HashMap<>();
		
		userMap.put(1, "김삼겹");
		userMap.put(2, "김사겹");
		userMap.put(3, "김오겹");
		userMap.put(4, "김육겹");
		userMap.put(5, "김칠겹");
		
		
		return ResponseEntity.ok().body(DataResponseDto.of(userMap.get(id)));
	}
	
	// form으로 받을 때는 @RequestBody를 빼고 받아줌.
//	// Post요청의 데이터 처리
//	@PostMapping("/create")
//	public ResponseEntity<? extends ResponseDto> create(BasicTestDto basicTestDto) {
//		System.out.println("데이터 추가");
//		
//		return ResponseEntity.created(null).body(DataResponseDto.of(basicTestDto));
//	}
	
	// JSON 형태로 받으려면 RequestBody 어노테이션을 매개변수 앞에 붙여줘야함
	// Post요청의 데이터 처리리
		@PostMapping("/create")
		public ResponseEntity<? extends ResponseDto> create(@RequestBody BasicTestDto basicTestDto) {
			System.out.println("데이터 추가");
			
			// created에 null에는 넘어갈 페이지의 uri를 지정해 줄 수 있다.
			return ResponseEntity.created(null).body(DataResponseDto.of(basicTestDto));
		}
}
