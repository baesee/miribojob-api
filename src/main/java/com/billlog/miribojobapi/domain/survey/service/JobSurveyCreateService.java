package com.billlog.miribojobapi.domain.survey.service;

import com.billlog.miribojobapi.domain.common.domain.constant.MemberCompanyAddress;
import com.billlog.miribojobapi.domain.common.domain.constant.MemberCompanyInfo;
import com.billlog.miribojobapi.domain.common.domain.constant.MemberCompanyWorkTimeInfo;
import com.billlog.miribojobapi.domain.member.dao.MemberRepository;
import com.billlog.miribojobapi.domain.survey.domain.JobSurvey;
import com.billlog.miribojobapi.domain.survey.dto.request.JobSurveyDto;
import com.billlog.miribojobapi.global.utils.CurrentLoginUserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class JobSurveyCreateService {
    private final MemberRepository memberRepository;
    private final CurrentLoginUserUtil currentLoginUserUtil;
    @Transactional
    public void createJobSurvey(JobSurveyDto.createSurveyRequest dto){
        Long memberNo = currentLoginUserUtil.getMemberNoByLoginUser();

        JobSurvey jobSurvey = JobSurvey.builder()
                .memberCompanyInfo(new MemberCompanyInfo(dto.getCompanyName(), dto.getCompanyRgstNo()))
                .memberCompanyAddress(new MemberCompanyAddress(dto.getSidoName(), dto.getSigoonguName()))
                .careerYear(dto.getCareerYear())
                .position(dto.getPosition())
                .jobDescription(dto.getJobDescription())
                .annualIncome(dto.getAnnualIncome())
                .realSalary(dto.getRealSalary())
                .workType(dto.getWorkType())
                .memberCompanyWorkTimeInfo(new MemberCompanyWorkTimeInfo(dto.getWorkingStartDate(), dto.getWorkingEndDate()))
                .workAndLifeScore(dto.getWorkAndLifeScore())
                .salaryScore(dto.getSalaryScore())
                .cultureScore(dto.getCultureScore())
                .welfareScore(dto.getWelfareScore())
                .visionScore(dto.getVisionScore())
                .trendSkillScore(dto.getTrendSkillScore())
                .studyCurriculum(dto.getStudyCurriculum())
                .deleteYn("N")
                .hits(0)
                .showChangJobHistoryYn(dto.getShowChangJobHistoryYn())
                .etc(dto.getEtc())
                .member(memberRepository.getReferenceById(memberNo))
                .build();
    }
}
