package com.web.study.service;

import org.springframework.stereotype.Service;

import com.web.study.domain.entity.Course;
import com.web.study.dto.request.course.CourseReqDto;
import com.web.study.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

	private final CourseRepository courseRepository;

	@Override
	public void registeCourse(CourseReqDto courseReqDto) {
//		System.out.println(courseReqDto);
		Course course = courseReqDto.toEntity();
		System.out.println("변환: " + course);
		courseRepository.saveCourse(course);
	}
}
