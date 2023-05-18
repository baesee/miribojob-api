package com.billlog.miribojobapi.common.public_data.company.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

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
    public void csvReadeTest() throws Exception{
        // given
        csvFileReaderService.saveTest("/Users/baesee/billlog-project/preview-job/testcsv.csv");
        // when

        // then
    }

}