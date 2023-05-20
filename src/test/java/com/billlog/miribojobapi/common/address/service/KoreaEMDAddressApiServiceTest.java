package com.billlog.miribojobapi.common.address.service;

import com.billlog.miribojobapi.common.public_data.address.service.KoreaEMDAddressApiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("local")
class KoreaEMDAddressApiServiceTest {
    private final KoreaEMDAddressApiService koreaEMDAddressApiService;
    @Autowired
    public KoreaEMDAddressApiServiceTest(KoreaEMDAddressApiService koreaEMDAddressApiService) {
        this.koreaEMDAddressApiService = koreaEMDAddressApiService;
    }

    @DisplayName("읍면동 데이터 등록")
    @Test
    @Rollback(false) // rollback 되지 않도록 설정
    public void externalEmdTest() throws Exception{
        // given
        koreaEMDAddressApiService.setEmdInfoToDB();
        // when
    
        // then
    }
}