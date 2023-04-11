package com.web.study.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.web.study.domain.entity.Lecture;

@Mapper
public interface LectureRepository {
	
	public int saveLecture(Lecture lecture);
	public List<Lecture> getLectureAll();
	public Lecture findLectureById(int id);
	// 건수가 많을 수 있기 때문에 무조건 List로 해줘야함!
	public List<Lecture> searchLecture(Map<String, Object> parameterMap);
	
}
