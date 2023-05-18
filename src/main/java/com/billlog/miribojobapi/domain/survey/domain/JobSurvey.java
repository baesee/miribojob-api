package com.billlog.miribojobapi.domain.survey.domain;

import com.billlog.miribojobapi.domain.common.domain.constant.MemberCompanyAddress;
import com.billlog.miribojobapi.domain.common.domain.constant.MemberCompanyInfo;
import com.billlog.miribojobapi.domain.common.domain.constant.MemberCompanyWorkTimeInfo;
import com.billlog.miribojobapi.domain.member.domain.Member;
import com.billlog.miribojobapi.global.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobSurvey extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobSurveyNo;
    @Embedded
    private MemberCompanyInfo memberCompanyInfo;
    @Embedded
    private MemberCompanyAddress memberCompanyAddress;
    private int careerYear;           // 년차
    private String position;    // 직급
    private String jobDescription;
    private int annualIncome;   // 연봉
    private int realSalary;     // 실수령 급여
    @Enumerated(EnumType.STRING)
    private WorkType workType; // 근무형태
    @Embedded
    private MemberCompanyWorkTimeInfo memberCompanyWorkTimeInfo; // 근무 시간
    private int workAndLifeScore;
    private int salaryScore;
    private int cultureScore;
    private int welfareScore;
    private int visionScore;
    private int trendSkillScore;
    private String studyCurriculum;
    private String businessTypeCode; // 사업장코드
    private String businessTypeName; // 사업장코드명

    @ColumnDefault("'N'")
    private String deleteYn;                     // 글 삭제여부
    @ColumnDefault("0")
    private int hits;
    @ColumnDefault("'N'")
    private String showChangJobHistoryYn;
    private String etc;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    @NotNull
    private Member member;
    @Builder
    public JobSurvey(Long jobSurveyNo, MemberCompanyInfo memberCompanyInfo, MemberCompanyAddress memberCompanyAddress, int careerYear, String position, String jobDescription, int annualIncome, int realSalary, WorkType workType, MemberCompanyWorkTimeInfo memberCompanyWorkTimeInfo, int workAndLifeScore, int salaryScore, int cultureScore, int welfareScore, int visionScore, int trendSkillScore, String studyCurriculum, String deleteYn, int hits, String showChangJobHistoryYn, String etc, Member member) {
        this.jobSurveyNo = jobSurveyNo;
        this.memberCompanyInfo = memberCompanyInfo;
        this.memberCompanyAddress = memberCompanyAddress;
        this.careerYear = careerYear;
        this.position = position;
        this.jobDescription = jobDescription;
        this.annualIncome = annualIncome;
        this.realSalary = realSalary;
        this.workType = workType;
        this.memberCompanyWorkTimeInfo = memberCompanyWorkTimeInfo;
        this.workAndLifeScore = workAndLifeScore;
        this.salaryScore = salaryScore;
        this.cultureScore = cultureScore;
        this.welfareScore = welfareScore;
        this.visionScore = visionScore;
        this.trendSkillScore = trendSkillScore;
        this.studyCurriculum = studyCurriculum;
        this.deleteYn = deleteYn;
        this.hits = hits;
        this.showChangJobHistoryYn = showChangJobHistoryYn;
        this.etc = etc;
        this.member = member;
    }
}
