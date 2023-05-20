package com.billlog.miribojobapi.common.public_data.company.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("local")
class CsvFileReaderServiceTest {
    private final CsvFileReaderService csvFileReaderService;
    @Autowired
    public CsvFileReaderServiceTest(CsvFileReaderService csvFileReaderService) {
        this.csvFileReaderService = csvFileReaderService;
    }

    @DisplayName("CSV Reader Test")
    @Test
    @Rollback(false) // rollback 되지 않도록 설정
    public void csvReadeTest() throws Exception{
        // given
        csvFileReaderService.setCompanyInfoSave("/Users/baesee/billlog-project/preview-job/testcsv.csv");
        // when

        // then
    }

}