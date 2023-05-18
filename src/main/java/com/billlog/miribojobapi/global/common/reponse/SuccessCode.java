package com.billlog.miribojobapi.global.common.reponse;

import lombok.Getter;

@Getter
public enum SuccessCode {
    /**
     * KD-SM-XXX
     * KD : Kildare
     * SM : Success Manage
     * XXX : S : 기본성공
     *
     */
    SUCCESS("SUCCESS", "KD-SM-S000")
    ;
    private final String status;
    private final String code;

    SuccessCode(String status, String code) {
        this.status = status;
        this.code = code;
    }
}
