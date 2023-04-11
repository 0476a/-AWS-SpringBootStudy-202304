package com.web.study.domain.entity;

import com.web.study.dto.response.FindLectureRespDto;
import com.web.study.dto.response.LectureRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Lecture {
	private int ltm_id;
	private String ltm_name;
	private int ltm_price;
	// itm_id는 외래키로 instructor와 join 하기 위함임!
	private int itm_id;
	private Instructor instructor;
	
	public LectureRespDto toDto() {
		return LectureRespDto.builder()
				.id(ltm_id)
				.lectureName(ltm_name)
				.lecturePrice(ltm_price)
				.instructorId(itm_id)
				.build();
	}
	
	public FindLectureRespDto findToDto() {
		String instructorName = null;
		
		// instructor 가 null 인지 확인해줘야함! (NullpointException 방지)
		if(instructor != null) {
			instructorName = instructor.getItm_name();
		}
		return FindLectureRespDto.builder()
				.lectureId(itm_id)
				.lectureName(ltm_name)
				.lecturePrice(ltm_price)
				.instructorName(instructorName)
				.build();
	}
}
