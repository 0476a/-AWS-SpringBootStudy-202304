package com.web.study.dto.response;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

// jackson이 자바에서 쓰던 녀석을 가지고 와야하므로 response때는 getter가 필요함!
@Builder
@Getter
public class LecturerRespDto {
	private int id;
	private String name;
	private LocalDate birthDate;
}
