package com.billlog.miribojobapi.common.public_data.company.domain;

import com.billlog.miribojobapi.global.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class KoreaCompanyInfo extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long koreaCompanyInfoNo;
    private String companyName;
    private String businessNumber;
    private String joinStatus; // 1 : 등록 , 2 : 탈퇴
    private String zipCode;
    private String emdFullName;
    private String emdCode;
    private String sidoCode;
    private String sigoonCode;
    private String dongCode;
    private String businessType; // 1 법인, 2 개인
    private String businessCategoryCode;
    private String businessCategoryName;

    @Builder
    public KoreaCompanyInfo(Long koreaCompanyInfoNo, String companyName, String businessNumber, String joinStatus, String zipCode, String emdFullName, String emdCode, String sidoCode, String sigoonCode, String dongCode, String businessType, String businessCategoryCode, String businessCategoryName) {
        this.koreaCompanyInfoNo = koreaCompanyInfoNo;
        this.companyName = companyName;
        this.businessNumber = businessNumber;
        this.joinStatus = joinStatus;
        this.zipCode = zipCode;
        this.emdFullName = emdFullName;
        this.emdCode = emdCode;
        this.sidoCode = sidoCode;
        this.sigoonCode = sigoonCode;
        this.dongCode = dongCode;
        this.businessType = businessType;
        this.businessCategoryCode = businessCategoryCode;
        this.businessCategoryName = businessCategoryName;
    }
}
