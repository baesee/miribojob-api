package com.billlog.miribojobapi.domain.survey.dto.reponse;

import com.billlog.miribojobapi.domain.survey.domain.JobSurvey;
import com.billlog.miribojobapi.domain.survey.domain.WorkType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class JobSurveyDetailResponseDto {
    private Long jobSurveyNo;
    private String companyName;
    private String companyRgstNo;   // 사업자 번호
    private String sidoName;
    private String sigoonguName;
    private int careerYear;
    private String position;
    private String jobDescription;
    private int annualIncome;
    private int realSalary;
    private WorkType workType;
    private LocalDate workingStartDate;
    private LocalDate workingEndDate;
    private int workAndLifeScore;
    private int salaryScore;
    private int cultureScore;
    private int welfareScore;
    private int visionScore;
    private int trendSkillScore;
    private String studyCurriculum;
    private int hits;
    private String showChangJobHistoryYn;
    private String etc;
    private String nickname;
    private Long memberNo;
    public JobSurveyDetailResponseDto(JobSurvey jobSurvey) {
        this.jobSurveyNo = jobSurvey.getJobSurveyNo();
        this.companyName = jobSurvey.getMemberCompanyInfo().getCompanyName();
        this.companyRgstNo = jobSurvey.getMemberCompanyInfo().getCompanyRgstNo();
        this.sidoName = jobSurvey.getMemberCompanyAddress().getSidoName();
        this.sigoonguName = jobSurvey.getMemberCompanyAddress().getSigoonguName();
        this.careerYear = jobSurvey.getCareerYear();
        this.position = jobSurvey.getPosition();
        this.jobDescription = jobSurvey.getJobDescription();
        this.annualIncome = jobSurvey.getAnnualIncome();
        this.realSalary = jobSurvey.getRealSalary();
        this.workType = jobSurvey.getWorkType();
        this.workingStartDate = jobSurvey.getMemberCompanyWorkTimeInfo().getWorkingStartDate();
        this.workingEndDate = jobSurvey.getMemberCompanyWorkTimeInfo().getWorkingEndDate();
        this.workAndLifeScore = jobSurvey.getWorkAndLifeScore();
        this.salaryScore = jobSurvey.getSalaryScore();
        this.cultureScore = jobSurvey.getCultureScore();
        this.welfareScore = jobSurvey.getWelfareScore();
        this.visionScore = jobSurvey.getVisionScore();
        this.trendSkillScore = jobSurvey.getTrendSkillScore();
        this.studyCurriculum = jobSurvey.getStudyCurriculum();
        this.hits = jobSurvey.getHits();
        this.showChangJobHistoryYn = jobSurvey.getShowChangJobHistoryYn();
        this.etc = jobSurvey.getEtc();
        this.nickname = jobSurvey.getMember().getNickname();
        this.memberNo = jobSurvey.getMember().getMemberNo();
    }
}
