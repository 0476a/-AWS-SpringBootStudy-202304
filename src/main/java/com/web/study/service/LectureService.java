package com.web.study.service;

import com.web.study.dto.request.lecture.LectureRegisteReqDto;
import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.request.lecture.LecturerReqDto;
import com.web.study.dto.request.lecture.StudentReqDto;

public interface LectureService {

	public void registeLecture(LectureReqDto lectureReqDto);
	public void registeLecturer(LecturerReqDto lecturerReqDto);
	public void registeLectureRegiste(LectureRegisteReqDto lectureRegisteReqDto);
	public void registeStudent(StudentReqDto studentReqDto);
}
