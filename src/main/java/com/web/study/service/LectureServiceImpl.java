package com.web.study.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.web.study.domain.entity.Lecture;
import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.response.FindLectureRespDto;
import com.web.study.dto.response.LectureRespDto;
import com.web.study.repository.LectureRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {

	// final => 상수: 초기화가 무조건 일어나야함.
	// 값을 무조건 넣어야하기 때문에 강제성이 생김.
	// -> spring이 IOC에서 값을 꺼내서 넣어줘야하겠다는 가이드가 잡힘.
	private final LectureRepository lectureRepository;

	@Override
	public void registeLecture(LectureReqDto lectureReqDto) {
		// DTO => ENTITY 변환
		Lecture lecture = lectureReqDto.toEntity();
		System.out.println("변환: " + lecture);
		// xml에 해당 매개변수를 전달하는 것임.
		lectureRepository.saveLecture(lecture);
	}

	@Override
	public List<LectureRespDto> getLectureAll() {
		List<LectureRespDto> dtos = new ArrayList<>();
		
		lectureRepository.getLectureAll().forEach(entity ->{
			dtos.add(entity.toDto());
		});
		
		return dtos;
	}

	@Override
	public LectureRespDto findLectureById(int id) {
		return lectureRepository.findLectureById(id).toDto();
	}

	@Override
	public List<FindLectureRespDto> searchLecture(int type, String searchValue) {
		// mybatis는 하나의 매개변수만 받을 수 있으므로 map으로 묶어줌.
		// map이 아닌 하나의 클래스로 만들어 줘도 됨.
		Map<String, Object> parameterMap = new HashMap<>();
		parameterMap.put("type", type);
		parameterMap.put("searchValue", searchValue);
		
		List<FindLectureRespDto> dtos = new ArrayList<>();
		// dto로 변환하기 위해서 forEach를 돌려준다.
		lectureRepository.searchLecture(parameterMap).forEach(entity -> {
			dtos.add(entity.findToDto());
		});
		
		return dtos;
	}
	

}
