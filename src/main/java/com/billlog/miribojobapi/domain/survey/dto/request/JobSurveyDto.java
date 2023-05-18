package com.billlog.miribojobapi.domain.survey.dto.request;

import com.billlog.miribojobapi.domain.survey.domain.WorkType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class JobSurveyDto {
    @Getter
    @Setter
    @Schema(description = "직업 설문조사 DTO")
    public static class createSurveyRequest {
        @Schema(description = "회사명")
        @NotBlank(message = "회사명은 필수사항입니다.")
        private String companyName;
        @Schema(description = "사업자 번호 앞자리")
        @NotBlank(message = "사업자 번호 앞자리는 필수사항입니다.")
        private String companyRgstNo;
        @Schema(description = "회사 지역(시도)")
        @NotBlank(message = "회사 지역(시도)은 필수사항입니다.")
        private String sidoName;
        @Schema(description = "회사 지역(시군)")
        @NotBlank(message = "회사 지역(시군)은 필수사항입니다.")
        private String sigoonguName;
        @Schema(description = "년차")
        @NotBlank(message = "년차는 필수사항입니다.")
        private int careerYear;
        @Schema(description = "직급")
        @NotBlank(message = "직급은 필수사항입니다.")
        private String position;
        @Schema(description = "직업 설명")
        @NotBlank(message = "직업 설명은 필수사항입니다.")
        private String jobDescription;
        @Schema(description = "연봉")
        private int annualIncome;
        @Schema(description = "실수령 급여")
        private int realSalary;
        @Schema(description = "근무형태")
        private WorkType workType;
        @Schema(description = "근무 시작 시간")
        private LocalDate workingStartDate;
        @Schema(description = "근무 종료 시간")
        private LocalDate workingEndDate;
        @Schema(description = "워라벨 점수")
        private int workAndLifeScore;
        @Schema(description = "급여 수준 점수")
        private int salaryScore;
        @Schema(description = "기업 문화 점수")
        private int cultureScore;
        @Schema(description = "복지 점수")
        private int welfareScore;
        @Schema(description = "회사 비전 점수")
        private int visionScore;
        @Schema(description = "스킬 트렌드 점수")
        private int trendSkillScore;
        @Schema(description = "직업을 갖기위한 학습 경로(커리큘럼)")
        private String studyCurriculum;
        @Schema(description = "이직 이력노출 여부")
        @NotBlank(message = "이직 이력노출 여부는 필수사항입니다.")
        private String showChangJobHistoryYn;
        @Schema(description = "특이사항")
        private String etc;
    }
}
