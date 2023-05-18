package com.billlog.miribojobapi.domain.common.domain.constant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberCompanyInfo {
    private String companyName;
    private String companyRgstNo;   // 사업자 번호

    public MemberCompanyInfo(String companyName, String companyRgstNo) {
        this.companyName = companyName;
        this.companyRgstNo = companyRgstNo;
    }
}
