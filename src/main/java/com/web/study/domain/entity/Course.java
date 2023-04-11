package com.web.study.domain.entity;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Course {
	private int csm_id;
	private int ltm_id;
	private int sdm_id;
	private LocalDate registe_date;
	private Lecture lecture;
	private Student student;

}
