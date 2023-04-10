package com.web.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.study.domain.entity.Student;
import com.web.study.dto.request.student.StudentReqDto;
import com.web.study.dto.response.StudentRespDto;
import com.web.study.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
	
	private final StudentRepository studentRepository;
	
	@Override
	public void registeStudent(StudentReqDto studentReqDto) {
		// 값이 잘 들어왔는지 확인해준다.
		// System.out.println(studentReqDto);
		
		Student student = studentReqDto.toEntity();
		System.out.println("변환: " + student);
		studentRepository.saveStudent(student);
	}
	
	public List<StudentRespDto> getStudents() {
		List<StudentRespDto> dtos = new ArrayList<>();
		studentRepository.getStudentAll().forEach(entity -> {
			dtos.add(entity.toDto());
		});
		
		return dtos;
	}
	
	public StudentRespDto findStudentById(int id) {
		return studentRepository.findStudentById(id).toDto();
	}

}
