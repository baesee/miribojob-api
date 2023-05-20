package com.billlog.miribojobapi.domain.survey.controller;

import com.billlog.miribojobapi.domain.survey.dto.request.JobSurveyDto;
import com.billlog.miribojobapi.domain.survey.service.JobSurveyCreateService;
import com.billlog.miribojobapi.domain.survey.service.JobSurveyLikeService;
import com.billlog.miribojobapi.domain.survey.service.JobSurveyQueryService;
import com.billlog.miribojobapi.global.common.reponse.ApiResponseDTO;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "직업 만족도 설문조사 등록")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/miribojob/api")
public class JobSurveyController {
    private final JobSurveyCreateService jobSurveyCreateService;
    private final JobSurveyLikeService jobSurveyLikeService;
    private final JobSurveyQueryService jobSurveyQueryService;
    @PostMapping(value = "/v1/survey/job")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "직업 만족도 설문조사 등록 성공", content = @Content(schema = @Schema(implementation = void.class))),
            @ApiResponse(responseCode = "4XX,5XX", description = "직업 만족도 설문조사 등록 실패", content = @Content(schema = @Schema(implementation = Void.class))),
    })
    @Operation(summary = "직업 만족도 설문조사 등록", description = "직업 만족도 설문조사 등록")
    public ResponseEntity<ApiResponseDTO> createJobSurvey(@Valid @RequestBody JobSurveyDto.createSurveyRequest dto) {
        jobSurveyCreateService.createJobSurvey(dto);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.SUCCESS());
    }
}
