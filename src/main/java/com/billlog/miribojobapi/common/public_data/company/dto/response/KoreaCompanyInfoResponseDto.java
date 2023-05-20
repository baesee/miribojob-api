package com.billlog.miribojobapi.common.public_data.company.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KoreaCompanyInfoResponseDto {
    private String companyName;
    private String companyBussinessNumber;
    private String companyBusinessCategoryCode;
    private String companyBusinessCategoryName;
    private String emdCode;
    private String emdFullName;
    private String sidoCode;
    private String sigoonCode;

    @QueryProjection
    public KoreaCompanyInfoResponseDto(String companyName, String companyBussinessNumber, String companyBusinessCategoryCode, String companyBusinessCategoryName, String emdCode, String emdFullName, String sidoCode, String sigoonCode) {
        this.companyName = companyName;
        this.companyBussinessNumber = companyBussinessNumber;
        this.companyBusinessCategoryCode = companyBusinessCategoryCode;
        this.companyBusinessCategoryName = companyBusinessCategoryName;
        this.emdCode = emdCode;
        this.emdFullName = emdFullName;
        this.sidoCode = sidoCode;
        this.sigoonCode = sigoonCode;
    }
}
