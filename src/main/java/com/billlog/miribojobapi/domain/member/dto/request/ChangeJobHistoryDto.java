package com.billlog.miribojobapi.domain.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class ChangeJobHistoryDto {
    @Getter
    @Setter
    @Schema(description = "이력 등록 DTO")
    public static class addHistoryRequest {
        @Schema(description = "회사명")
        @NotBlank(message = "회사명는 필수사항입니다.")
        private String companyName;
        @Schema(description = "사업자 번호")
        @NotBlank(message = "사업자 번호는 필수사항입니다.")
        private String companyRgstNo;
        @Schema(description = "회사 지역(시도)")
        @NotBlank(message = "회사 지역(시도)은 필수사항입니다.")
        private String sidoName;
        @Schema(description = "회사 지역(시군)")
        @NotBlank(message = "회사 지역(시군)은 필수사항입니다.")
        private String sigoonguName;
        @Schema(description = "직급")
        @NotBlank(message = "직급은 필수사항입니다.")
        private String position;
        @Schema(description = "근무 시작 시간")
        private LocalDate workingStartDate;
        @Schema(description = "근무 종료 시간")
        private LocalDate workingEndDate;

    }
}
