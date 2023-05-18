package com.billlog.miribojobapi.domain.survey.dao.custom;

import com.billlog.miribojobapi.domain.survey.dto.reponse.JobSurveyListResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface JobSurveyQueryCustom {
    Slice<JobSurveyListResponseDto> findJobSurveyByCondition(Pageable pageable);
}
