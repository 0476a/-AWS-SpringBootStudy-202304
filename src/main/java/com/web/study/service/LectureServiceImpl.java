package com.web.study.service;

import org.springframework.stereotype.Service;


import com.web.study.domain.entity.Lecture;
import com.web.study.domain.entity.LectureRegiste;
import com.web.study.domain.entity.Lecturer;
import com.web.study.domain.entity.Student;
import com.web.study.dto.request.lecture.LectureRegisteReqDto;
import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.request.lecture.LecturerReqDto;
import com.web.study.dto.request.lecture.StudentReqDto;
import com.web.study.repository.LectureRegisteRepository;
import com.web.study.repository.LectureRepository;
import com.web.study.repository.LecturerRepository;
import com.web.study.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService{
	
	private final LectureRepository lectureRepository;
	private final LecturerRepository lecturerRepository;
	private final LectureRegisteRepository lectureRegisteRepository;
	private final StudentRepository studentRepository;

	@Override
	public void registeLecture(LectureReqDto lectureReqDto) {
		// DTO => ENTITY 변환
		Lecture lecture = lectureReqDto.toEntity();
		System.out.println("변환: " + lecture);
		// xml에 해당 매개변수를 전달하는 것임.
		lectureRepository.registe(lecture);
	}
	
	@Override
	public void registeLecturer(LecturerReqDto lecturerReqDto) {
		Lecturer lecturer = lecturerReqDto.toEntity();
		System.out.println("변환: " + lecturer);
		lecturerRepository.registe(lecturer);
	}

	@Override
	public void registeLectureRegiste(LectureRegisteReqDto lectureRegisteReqDto) {
		LectureRegiste lectureRegiste = lectureRegisteReqDto.toEntity();
		System.out.println("변환: " + lectureRegiste);
		lectureRegisteRepository.registe(lectureRegiste);
	}

	@Override
	public void registeStudent(StudentReqDto studentReqDto) {
		Student student = studentReqDto.toEntity();
		System.out.println("변환: " + student);
		studentRepository.registe(student);
	}

}
