package com.web.study.repository;

import org.apache.ibatis.annotations.Mapper;


import com.web.study.domain.entity.Lecturer;

@Mapper
public interface LecturerRepository {
	
	public int registe(Lecturer lecturer);
}
