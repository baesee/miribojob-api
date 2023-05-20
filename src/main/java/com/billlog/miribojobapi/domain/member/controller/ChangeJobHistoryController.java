package com.billlog.miribojobapi.domain.member.controller;

import com.billlog.miribojobapi.domain.member.dto.request.ChangeJobHistoryDto;
import com.billlog.miribojobapi.domain.member.service.ChangeJobHistoryService;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "이직정보 관리")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/miribojob/api")
public class ChangeJobHistoryController {
    private final ChangeJobHistoryService changeJobHistoryService;

    @PostMapping(value = "/v1/member/job-history")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "이직정보 등록 성공", content = @Content(schema = @Schema(implementation = void.class))),
            @ApiResponse(responseCode = "4XX,5XX", description = "이직정보 등록 실패", content = @Content(schema = @Schema(implementation = Void.class))),
    })
    @Operation(summary = "이직 정보 등록", description = "이직 정보 등록")
    public ResponseEntity<ApiResponseDTO> addChangeJobHistory(@Valid @RequestBody ChangeJobHistoryDto.addHistoryRequest dto) {
        changeJobHistoryService.addChangeJobHistory(dto);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.SUCCESS());
    }

    @GetMapping(value = "/v1/member/job-history/{memberNo}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "이직 정보 조회 성공", content = @Content(schema = @Schema(implementation = Boolean.class, description = "true : 중복 , false : 미중복"))),
            @ApiResponse(responseCode = "4XX,5XX", description = "이직 정보 조회 실패", content = @Content(schema = @Schema(implementation = Void.class))),
    })
    @Operation(summary = "이직 정보 조회", description = "이직 정보 조회")
    public ResponseEntity<ApiResponseDTO> checkNicknameDuplicate(@Schema(description = "멤버 번호") @PathVariable("memberNo") Long memberNo) {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.SUCCESS(changeJobHistoryService.getChangeJobHistoryList(memberNo)));
    }
}
