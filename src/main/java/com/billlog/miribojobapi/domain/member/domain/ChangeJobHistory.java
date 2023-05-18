package com.billlog.miribojobapi.domain.member.domain;

import com.billlog.miribojobapi.domain.common.domain.constant.MemberCompanyAddress;
import com.billlog.miribojobapi.domain.common.domain.constant.MemberCompanyInfo;
import com.billlog.miribojobapi.domain.common.domain.constant.MemberCompanyWorkTimeInfo;
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
public class ChangeJobHistory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long changeJobHistoryNo;
    @Embedded
    private MemberCompanyInfo memberCompanyInfo;
    @Embedded
    private MemberCompanyAddress memberCompanyAddress;
    @Embedded
    private MemberCompanyWorkTimeInfo memberCompanyWorkTimeInfo;
    private String position;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    @NotNull
    private Member member;

    @Builder
    public ChangeJobHistory(Long changeJobHistoryNo, MemberCompanyInfo memberCompanyInfo, MemberCompanyAddress memberCompanyAddress, MemberCompanyWorkTimeInfo memberCompanyWorkTimeInfo, String position, Member member) {
        this.changeJobHistoryNo = changeJobHistoryNo;
        this.memberCompanyInfo = memberCompanyInfo;
        this.memberCompanyAddress = memberCompanyAddress;
        this.memberCompanyWorkTimeInfo = memberCompanyWorkTimeInfo;
        this.position = position;
        this.member = member;
    }
}
