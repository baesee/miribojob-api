package com.billlog.miribojobapi.common.public_data.address.domain;

import com.billlog.miribojobapi.global.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KoreaEmdCode extends BaseTimeEntity {
    @Id
    private String emdCode;
    private String sidoCode;
    private String sidoName;
    private String sigoonCode;
    private String sigoonName;
    private String dongCode;
    private String dongName;
    private String emdFullName;
    @ColumnDefault("'N'")
    private String deleteYn;

    @Builder
    public KoreaEmdCode(String emdCode, String sidoCode, String sidoName, String sigoonCode, String sigoonName, String dongCode, String dongName, String emdFullName, String deleteYn) {
        this.emdCode = emdCode;
        this.sidoCode = sidoCode;
        this.sidoName = sidoName;
        this.sigoonCode = sigoonCode;
        this.sigoonName = sigoonName;
        this.dongCode = dongCode;
        this.dongName = dongName;
        this.emdFullName = emdFullName;
        this.deleteYn = deleteYn;
    }
}
