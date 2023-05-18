package com.billlog.miribojobapi.domain.survey.dao.impl;

import com.billlog.miribojobapi.domain.survey.dao.custom.JobSurveyQueryCustom;
import com.billlog.miribojobapi.domain.survey.dto.reponse.JobSurveyListResponseDto;
import com.billlog.miribojobapi.domain.survey.dto.reponse.QJobSurveyListResponseDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import javax.persistence.EntityManager;
import java.util.List;

import static com.billlog.miribojobapi.domain.survey.domain.QJobSurvey.jobSurvey;
import static com.billlog.miribojobapi.global.utils.QueryDslPagingUtil.sliceReturnByResults;

public class JobSurveyRepositoryImpl implements JobSurveyQueryCustom {
    private final JPAQueryFactory queryFactory;
    public JobSurveyRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Slice<JobSurveyListResponseDto> findJobSurveyByCondition(Pageable pageable) {
        List<JobSurveyListResponseDto> results = queryFactory
                .select(new QJobSurveyListResponseDto(
                        jobSurvey.jobSurveyNo,
                        jobSurvey.careerYear,
                        jobSurvey.realSalary,
                        jobSurvey.workAndLifeScore,
                        jobSurvey.salaryScore,
                        jobSurvey.cultureScore,
                        jobSurvey.welfareScore,
                        jobSurvey.visionScore,
                        jobSurvey.trendSkillScore
                ))
                .from(jobSurvey)
                .where(
                        fixedCondition()
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .orderBy(jobSurvey.createDate.desc())
                .fetch();

        return sliceReturnByResults(pageable, results);
    }

    private BooleanExpression fixedCondition() {
        return jobSurvey.deleteYn.eq("N");
    }
}
