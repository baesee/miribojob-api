package com.billlog.miribojobapi.domain.survey.service;

import com.billlog.miribojobapi.domain.survey.dao.JobSurveyRepository;
import com.billlog.miribojobapi.domain.survey.dto.reponse.JobSurveyDetailResponseDto;
import com.billlog.miribojobapi.domain.survey.dto.reponse.JobSurveyListResponseDto;
import com.billlog.miribojobapi.global.dto.CommonListResultDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JobSurveyQueryService {
    private final JobSurveyRepository jobSurveyRepository;
    public CommonListResultDto getJobSurveyList(int page){
        Slice<JobSurveyListResponseDto> jobSurveyListSlice = jobSurveyRepository.findJobSurveyByCondition(PageRequest.of(page - 1, 20));
        return CommonListResultDto.builder()
                .list(jobSurveyListSlice.getContent())
                .isFirst(jobSurveyListSlice.isFirst())
                .isLast(jobSurveyListSlice.isLast())
                .currentPageNumber(jobSurveyListSlice.getPageable().getPageNumber() + 1)
                .hasNext(jobSurveyListSlice.hasNext())
                .build();
    }

    public JobSurveyDetailResponseDto getJobSurveyDetail(Long jobSurveyNo){
        return jobSurveyRepository.findByJobSurveyNoAndDeleteYn(jobSurveyNo, "N")
                .map(JobSurveyDetailResponseDto::new)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 게시글 입니다."));
    }
}
