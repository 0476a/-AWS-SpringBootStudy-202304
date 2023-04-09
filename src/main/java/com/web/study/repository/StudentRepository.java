package com.web.study.repository;

import org.apache.ibatis.annotations.Mapper;

import com.web.study.domain.entity.Student;

@Mapper
public interface StudentRepository {

	public int registe(Student student);
}
