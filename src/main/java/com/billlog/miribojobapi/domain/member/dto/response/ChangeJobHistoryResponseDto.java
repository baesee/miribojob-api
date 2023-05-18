package com.billlog.miribojobapi.domain.member.dto.response;

import com.billlog.miribojobapi.domain.member.domain.ChangeJobHistory;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class ChangeJobHistoryResponseDto {
    private Long changeJobHistoryNo;
    private String companyName;
    private String companyRgstNo;
    private String sidoName;
    private String sigoonguName;
    private LocalDate workingStartDate;
    private LocalDate workingEndDate;
    private String position;
    private Long memberNo;
    public ChangeJobHistoryResponseDto(ChangeJobHistory changeJobHistory) {
        this.changeJobHistoryNo = changeJobHistory.getChangeJobHistoryNo();
        this.companyName = changeJobHistory.getMemberCompanyInfo().getCompanyName();
        this.companyRgstNo = changeJobHistory.getMemberCompanyInfo().getCompanyRgstNo();
        this.sidoName = changeJobHistory.getMemberCompanyAddress().getSidoName();
        this.sigoonguName = changeJobHistory.getMemberCompanyAddress().getSigoonguName();
        this.workingStartDate = changeJobHistory.getMemberCompanyWorkTimeInfo().getWorkingStartDate();
        this.workingEndDate = changeJobHistory.getMemberCompanyWorkTimeInfo().getWorkingEndDate();
        this.position = changeJobHistory.getPosition();
        this.memberNo = changeJobHistory.getMember().getMemberNo();
    }
}
