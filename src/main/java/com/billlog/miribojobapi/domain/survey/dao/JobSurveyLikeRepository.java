package com.billlog.miribojobapi.domain.survey.dao;

import com.billlog.miribojobapi.domain.survey.domain.JobSurveyLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobSurveyLikeRepository extends JpaRepository<JobSurveyLike, Long>{
    Optional<JobSurveyLike> findByJobSurvey_JobSurveyNoAndMember_MemberNo(Long jobSurveyNo, Long memberNo);
}
