package com.web.study.dto.request.lecturer;

import java.time.LocalDate;

import com.web.study.domain.entity.Lecturer;

import lombok.Setter;
import lombok.ToString;

// jackson이 외부에서부터 JSON을 받아와서 값을 가공해야하므로 request때는 Setter를 사용함!
@Setter
@ToString
public class LecturerReqDto {
	private String name;
	private LocalDate birthDate;
	
	public Lecturer toEntity() {
		return Lecturer.builder()
				.name(name)
				.birth_date(birthDate)
				.build();
	}
}
