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
import com.web.study.dto.request.BasicTestDto3;

@RestController
public class BasicController3 {
	
	// 노래 제목으로 노래제목 찾아서 받아온 값을 다시 답장해줌.
	@GetMapping("/music/read")
	public ResponseEntity<? extends ResponseDto> read(String musicName) {
		System.out.println(musicName);
		return ResponseEntity.ok().body(DataResponseDto.of(musicName));
	}
	
	// 영화 제목, 주인공, 감독 이름을 찾아서 받아온 값을 다시 답장해줌.
	@GetMapping("/movie/reads")
	public ResponseEntity<? extends ResponseDto> reads(String movieName, String mainCharacter, String director) {
		
		String movieInfo = "영화제목:" + movieName + ", 주인공:" + mainCharacter + ", 감독:" + director;
		System.out.println(movieInfo);
		return ResponseEntity.ok().body(DataResponseDto.of(movieInfo));
		
	}
	
	// 옷의 고유 코드를 pathvariable로 받아서 값을 찾아서 답장해주기
	@GetMapping("/wear/path/read/{wearCode}")
	public ResponseEntity<? extends ResponseDto> read2(@PathVariable String wearCode) {
		Map<String, String> wearMap = new HashMap<>();
		wearMap.put("a", "크록스");
		wearMap.put("b", "슬랙스");
		wearMap.put("c", "로퍼");
		wearMap.put("d", "자켓");
		wearMap.put("e", "후드티");
		
		System.out.println(wearMap.get(wearCode));
		
		return ResponseEntity.ok().body(DataResponseDto.of(wearMap.get(wearCode)));
	}
	
	// 음악의 정보를 입력받아서 해당 값에 해당 하는 곡의 정보를 답장해줌.
	@GetMapping("/music/read/all")
	public ResponseEntity<? extends ResponseDto> readAll(BasicTestDto3 basicTestDto3) {
		
		String musicInfo = "플레이리스트 번호: " + basicTestDto3.getMusicId()
						+ ", 노래제목: " + basicTestDto3.getMusicName()
						+ ", 가수: " + basicTestDto3.getSinger()
						+ ", 작곡가: " + basicTestDto3.getSongWriter()
						+ ", 작사가: " + basicTestDto3.getLyrirWriter()
						+ ", 국가: " + basicTestDto3.getNation();
		
		System.out.println(musicInfo);
		
		return ResponseEntity.ok().body(DataResponseDto.of(musicInfo));
	}
	
	// 추가하고 싶은 곡의 정보를 Post의 form에서 받고 해당 객체를 다시 응답해줌.
	@PostMapping("/music/create/form")
	public ResponseEntity<? extends ResponseDto> createForm(BasicTestDto3 basicTestDto3) {
		
		System.out.println(basicTestDto3);
		
		return ResponseEntity.created(null).body(DataResponseDto.of(basicTestDto3));
	}
	
	// 추가하고 싶은 곡의 정보를 Post의 json에서 받고 해당 객체를 다시 응답해줌.
	@PostMapping("/music/create/json")
	public ResponseEntity<? extends ResponseDto> createJson(@RequestBody BasicTestDto3 basicTestDto3) {
		
		System.out.println(basicTestDto3);
		
		return ResponseEntity.created(null).body(DataResponseDto.of(basicTestDto3));
	}
	
	
}
