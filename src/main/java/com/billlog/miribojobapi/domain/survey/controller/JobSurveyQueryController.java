package com.billlog.miribojobapi.domain.survey.controller;

import com.billlog.miribojobapi.domain.survey.dto.reponse.JobSurveyDetailResponseDto;
import com.billlog.miribojobapi.domain.survey.dto.reponse.JobSurveyListResponseDto;
import com.billlog.miribojobapi.domain.survey.service.JobSurveyLikeService;
import com.billlog.miribojobapi.domain.survey.service.JobSurveyQueryService;
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
import org.springframework.web.bind.annotation.*;

@Tag(name = "미리보잡 조회")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/miribojob/api")
public class JobSurveyQueryController {
    private final JobSurveyQueryService jobSurveyQueryService;
    private final JobSurveyLikeService jobSurveyLikeService;
    @GetMapping(value = "/v1/mrbj")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "미리보잡 목록 조회 성공(공통 목록 응답값 포멧)", content = @Content(schema = @Schema(implementation = CommonListResultDto.class))),
            @ApiResponse(responseCode = "201", description = "미리보잡 목록 조회 성공", content = @Content(schema = @Schema(implementation = JobSurveyListResponseDto.class))),
            @ApiResponse(responseCode = "401", description = "인증이 필요합니다.", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "403", description = "권한이 없습니다.", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "4XX,5XX", description = "미리보잡 목록 조회 실패", content = @Content(schema = @Schema(implementation = Void.class))),
    })
    @Operation(summary = "미리보잡 목록 조회", description = "미리보잡 목록 조회")
    public ResponseEntity<ApiResponseDTO> miribojobList(@Schema(description = "페이지") @RequestParam("page") int page) {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.SUCCESS(jobSurveyQueryService.getJobSurveyList(page)));
    }

    @GetMapping(value = "/v1/mrbj/{jobSurveyNo}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "미리보잡 상세조회 성공", content = @Content(schema = @Schema(implementation = JobSurveyDetailResponseDto.class))),
            @ApiResponse(responseCode = "401", description = "인증이 필요합니다.", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "403", description = "권한이 없습니다.", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "4XX,5XX", description = "미리보잡 상세조회 실패", content = @Content(schema = @Schema(implementation = Void.class))),
    })
    @Operation(summary = "미리보잡 상세조회", description = "미리보잡 상세조회")
    public ResponseEntity<ApiResponseDTO> miribojobDetail(@Schema(description = "미리보잡 번호") @PathVariable("jobSurveyNo") Long jobSurveyNo) {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.SUCCESS(jobSurveyQueryService.getJobSurveyDetail(jobSurveyNo)));
    }

    @PostMapping(value = "/v1/mrbj/like")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "미리보잡 좋아요 / 미리보잡 좋아요 해지 성공", content = @Content(schema = @Schema(implementation = String.class, description = "좋아요('ON'), 좋아요 해지('OFF')"))),
            @ApiResponse(responseCode = "401", description = "인증이 필요합니다.", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "403", description = "권한이 없습니다.", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "4XX,5XX", description = "미리보잡 좋아요 / 미리보잡 좋아요 해지 실패", content = @Content(schema = @Schema(implementation = Void.class))),
    })
    @Operation(summary = "미리보잡 좋아요('ON') / 미리보잡 좋아요 해지('OFF')", description = "미리보잡 좋아요('ON') / 미리보잡 좋아요 해지('OFF')")
    public ResponseEntity<ApiResponseDTO> anonymounBoardLike(@Schema(description = "미리보잡 번호") @PathVariable("jobSurveyNo") Long jobSurveyNo) {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.SUCCESS(jobSurveyLikeService.setJobSurveyLike(jobSurveyNo)));
    }
}
