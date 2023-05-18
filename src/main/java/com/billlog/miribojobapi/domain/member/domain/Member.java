package com.billlog.miribojobapi.domain.member.domain;

import com.billlog.miribojobapi.domain.common.domain.constant.MemberCompanyAddress;
import com.billlog.miribojobapi.domain.common.domain.constant.MemberCompanyInfo;
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
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;
    @NotNull
    private String memberId;
    @NotNull
    private String password;
    @NotNull
    private String nickname;
    @Embedded
    private MemberCompanyInfo memberCompanyInfo;
    @Embedded
    private MemberCompanyAddress memberCompanyAddress;
    @NotNull
    private String policyAgree;

    @Builder
    public Member(Long memberNo, String memberId, String password, String nickname, MemberCompanyInfo memberCompanyInfo, MemberCompanyAddress memberCompanyAddress, String policyAgree) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.password = password;
        this.nickname = nickname;
        this.memberCompanyInfo = memberCompanyInfo;
        this.memberCompanyAddress = memberCompanyAddress;
        this.policyAgree = policyAgree;
    }
    public void changePassword(String password){
        this.password = password;
    }
    public void changeNickname(String nickname){
        this.nickname = nickname;
    }
}
