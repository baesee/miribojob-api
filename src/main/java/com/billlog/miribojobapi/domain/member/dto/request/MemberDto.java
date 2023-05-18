package com.billlog.miribojobapi.domain.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class MemberDto {
    @Getter
    @Setter
    @Schema(description = "회원가입 DTO")
    public static class JoinRequest {
        @Schema(description = "유저 아이디(email)")
        @NotBlank(message = "사용자 아이디는 필수사항입니다.")
        private String memberId;
        @Schema(description = "패스워드")
        @NotBlank(message = "비밀번호는 필수사항입니다.")
        private String password;
        @Schema(description = "닉네임")
        @NotBlank(message = "닉네임은 필수사항입니다.")
        private String nickname;
        @Schema(description = "이용약관 여부")
        @NotBlank(message = "이용약관 동의 여부는 필수사항입니다.")
        private String policyAgree;
    }
}
