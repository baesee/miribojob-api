package com.billlog.miribojobapi.domain.survey.domain;

import com.billlog.miribojobapi.domain.member.domain.Member;
import com.billlog.miribojobapi.global.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobSurveyLike extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobSurveyLikeNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_survey_no")
    @NotNull
    private JobSurvey jobSurvey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    @NotNull
    private Member member;
    @Builder
    public JobSurveyLike(Long jobSurveyLikeNo, JobSurvey jobSurvey, Member member) {
        this.jobSurveyLikeNo = jobSurveyLikeNo;
        this.jobSurvey = jobSurvey;
        this.member = member;
    }
}
