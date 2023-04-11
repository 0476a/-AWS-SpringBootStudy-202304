package com.web.study.service;

import java.util.List;

import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.response.FindLectureRespDto;
import com.web.study.dto.response.LectureRespDto;

public interface LectureService {

	public void registeLecture(LectureReqDto lectureReqDto);
	public List<LectureRespDto> getLectureAll();
	public LectureRespDto findLectureById(int id);
	public List<FindLectureRespDto> searchLecture(int type, String searchValue);
	
}
