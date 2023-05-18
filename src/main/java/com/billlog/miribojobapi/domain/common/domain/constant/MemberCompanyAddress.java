package com.billlog.miribojobapi.domain.common.domain.constant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberCompanyAddress {
    private String sidoName;
    private String sigoonguName;

    public MemberCompanyAddress(String sidoName, String sigoonguName) {
        this.sidoName = sidoName;
        this.sigoonguName = sigoonguName;
    }
}
