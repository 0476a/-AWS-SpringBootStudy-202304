package com.web.study.dto.request.lecture;

import com.web.study.domain.entity.Lecture;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class LectureReqDto {
	private String lectureName;
	private int lecturePrice;
	private int lecturerId;
	
	// getter를 않쓰는 상황
	// Dto 값을 Entity로 바꿔주는 메소드
	public Lecture toEntity() {
		return Lecture.builder()
				.lecture_name(lectureName)
				.lecture_price(lecturePrice)
				.lecturer_id(lecturerId)
				.build();
	}
}
