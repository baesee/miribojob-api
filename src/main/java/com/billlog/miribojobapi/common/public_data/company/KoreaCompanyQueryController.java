package com.billlog.miribojobapi.common.public_data.company;

import com.billlog.miribojobapi.common.public_data.company.service.CompanyInfoQueryService;
import com.billlog.miribojobapi.domain.survey.dto.reponse.JobSurveyListResponseDto;
import com.billlog.miribojobapi.global.common.reponse.ApiResponseDTO;
import com.billlog.miribojobapi.global.dto.CommonListResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "회사정보 조회")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/miribojob/api")
public class KoreaCompanyQueryController {
    private final CompanyInfoQueryService companyInfoQueryService;
    @GetMapping(value = "/v1/public-data/company")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회사 목록 조회 성공(공통 목록 응답값 포멧)", content = @Content(schema = @Schema(implementation = CommonListResultDto.class))),
            @ApiResponse(responseCode = "201", description = "회사 목록 조회 성공", content = @Content(schema = @Schema(implementation = JobSurveyListResponseDto.class))),
            @ApiResponse(responseCode = "4XX,5XX", description = "회사 목록 조회 실패", content = @Content(schema = @Schema(implementation = Void.class))),
    })
    @Operation(summary = "회사 목록 조회", description = "회사 목록 조회")
    public ResponseEntity<ApiResponseDTO> companyInfoList(@Schema(description = "회사명") @RequestParam(value = "companyName", required = false) String companyName,
                                                          @Schema(description = "시도 코드(2자리)") @RequestParam(value = "sidoCode", required = false) String sidoCode,
                                                          @Schema(description = "페이지") @RequestParam(value = "businessCategoryCode", required = false) String businessCategoryCode,
                                                          @Schema(description = "페이지") @RequestParam("page") int page) {
        System.out.println("companyName = " + companyName);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.SUCCESS(companyInfoQueryService.getCompanyInfoList(companyName, sidoCode, businessCategoryCode, page)));
    }
}
