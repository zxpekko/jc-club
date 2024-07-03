package com.jingdianjichi.practice.server.service;

import com.jingdianjichi.practice.api.req.GetPracticeSubjectsReq;
import com.jingdianjichi.practice.api.vo.PracticeSetVO;
import com.jingdianjichi.practice.api.vo.PracticeSubjectListVO;
import com.jingdianjichi.practice.api.vo.PracticeSubjectVO;
import com.jingdianjichi.practice.api.vo.SpecialPracticeVO;
import com.jingdianjichi.practice.server.entity.dto.PracticeSubjectDTO;

import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:52 2024/6/2
 */
public interface PracticeSetService {

    List<SpecialPracticeVO> getSpecialPracticeContent();

    PracticeSetVO addPractice(PracticeSubjectDTO dto);

    PracticeSubjectListVO getSubjects(GetPracticeSubjectsReq req);

    PracticeSubjectVO getPracticeSubject(PracticeSubjectDTO dto);
}
