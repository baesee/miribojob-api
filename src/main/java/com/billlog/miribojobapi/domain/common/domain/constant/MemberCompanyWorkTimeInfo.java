package com.billlog.miribojobapi.domain.common.domain.constant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberCompanyWorkTimeInfo {
    private LocalDate workingStartDate;
    private LocalDate workingEndDate;

    public MemberCompanyWorkTimeInfo(LocalDate workingStartDate, LocalDate workingEndDate) {
        this.workingStartDate = workingStartDate;
        this.workingEndDate = workingEndDate;
    }
}
