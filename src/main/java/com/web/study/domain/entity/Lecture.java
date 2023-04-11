package com.web.study.domain.entity;

import com.web.study.dto.response.LectureRespDto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Lecture {
	private int ltm_id;
	private String ltm_name;
	private int ltm_price;
	private int itm_id;
	
	public LectureRespDto toDto() {
		return LectureRespDto.builder()
				.id(ltm_id)
				.lectureName(ltm_name)
				.lecturePrice(ltm_price)
				.instructorId(itm_id)
				.build();
	}
}
