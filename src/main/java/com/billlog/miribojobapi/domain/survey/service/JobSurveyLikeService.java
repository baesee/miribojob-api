package com.billlog.miribojobapi.domain.survey.service;

import com.billlog.miribojobapi.domain.member.dao.MemberRepository;
import com.billlog.miribojobapi.domain.survey.dao.JobSurveyLikeRepository;
import com.billlog.miribojobapi.domain.survey.dao.JobSurveyRepository;
import com.billlog.miribojobapi.domain.survey.domain.JobSurveyLike;
import com.billlog.miribojobapi.domain.survey.dto.reponse.JobSurveyDetailResponseDto;
import com.billlog.miribojobapi.domain.survey.dto.reponse.JobSurveyListResponseDto;
import com.billlog.miribojobapi.global.dto.CommonListResultDto;
import com.billlog.miribojobapi.global.utils.CurrentLoginUserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class JobSurveyLikeService {
    private final JobSurveyLikeRepository jobSurveyLikeRepository;
    private final JobSurveyRepository jobSurveyRepository;
    private final MemberRepository memberRepository;
    private final CurrentLoginUserUtil currentLoginUserUtil;

    public String setJobSurveyLike(Long jobSurveyNo){
        Long memberNo = currentLoginUserUtil.getMemberNoByLoginUser();

        Optional<JobSurveyLike> jobSurveyByUserId =
                jobSurveyLikeRepository.findByJobSurvey_JobSurveyNoAndMember_MemberNo(jobSurveyNo, memberNo);

        if (jobSurveyByUserId.isPresent()) {
            jobSurveyLikeRepository.deleteById(jobSurveyByUserId.get().getJobSurveyLikeNo());
            return "OFF";
        }

        JobSurveyLike jobSurveyLike = JobSurveyLike.builder()
                .jobSurvey(jobSurveyRepository.getReferenceById(jobSurveyNo))
                .member(memberRepository.getReferenceById(memberNo))
                .build();

        jobSurveyLikeRepository.save(jobSurveyLike);

        return "ON";
    }

}
