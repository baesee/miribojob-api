package com.billlog.miribojobapi.domain.survey.dto.reponse;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JobSurveyListResponseDto {
    private Long jobSurveyNo;
    private int careerYear;
    private int realSalary;
    private int workAndLifeScore;
    private int salaryScore;
    private int cultureScore;
    private int welfareScore;
    private int visionScore;
    private int trendSkillScore;
    private int likeCount;
    @QueryProjection
    public JobSurveyListResponseDto(Long jobSurveyNo, int careerYear, int realSalary, int workAndLifeScore, int salaryScore, int cultureScore, int welfareScore, int visionScore, int trendSkillScore) {
        this.jobSurveyNo = jobSurveyNo;
        this.careerYear = careerYear;
        this.realSalary = realSalary;
        this.workAndLifeScore = workAndLifeScore;
        this.salaryScore = salaryScore;
        this.cultureScore = cultureScore;
        this.welfareScore = welfareScore;
        this.visionScore = visionScore;
        this.trendSkillScore = trendSkillScore;
    }
}
