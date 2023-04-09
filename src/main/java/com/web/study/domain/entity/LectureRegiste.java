package com.web.study.domain.entity;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class LectureRegiste {
	private int id;
	private int lecture_id;
	private int student_id;
	private LocalDate registe_date;

}
