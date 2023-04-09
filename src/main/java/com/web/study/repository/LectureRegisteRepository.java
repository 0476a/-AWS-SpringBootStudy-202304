package com.web.study.repository;

import org.apache.ibatis.annotations.Mapper;

import com.web.study.domain.entity.LectureRegiste;

@Mapper
public interface LectureRegisteRepository {
	
	public int registe(LectureRegiste lectureRegiste);
}
