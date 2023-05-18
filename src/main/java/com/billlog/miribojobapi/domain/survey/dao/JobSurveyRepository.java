package com.billlog.miribojobapi.domain.survey.dao;

import com.billlog.miribojobapi.domain.survey.dao.custom.JobSurveyQueryCustom;
import com.billlog.miribojobapi.domain.survey.domain.JobSurvey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobSurveyRepository extends JpaRepository<JobSurvey, Long> , JobSurveyQueryCustom {
    Optional<JobSurvey> findByJobSurveyNoAndDeleteYn(Long jobSurveyNo, String deleteYn);
}
