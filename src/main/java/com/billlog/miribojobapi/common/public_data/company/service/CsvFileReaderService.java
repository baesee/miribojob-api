package com.billlog.miribojobapi.common.public_data.company.service;

import com.billlog.miribojobapi.common.public_data.company.dao.KoreaCompanyInfoRepository;
import com.billlog.miribojobapi.common.public_data.company.domain.KoreaCompanyInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CsvFileReaderService<T> {

    private final KoreaCompanyInfoRepository koreaCompanyInfoRepository;

    private List<T> fileReadByLine(String fileName) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<T> resultList = new ArrayList<>();

        String line = "";
        br.readLine(); // 첫번째 타이틀 행 Skip

        while ((line = br.readLine()) != null) {
            try {
                resultList.add((T) parse(line));
            } catch (Exception e) {
                log.error("파싱 중 문제가 생겨 이 라인은 넘어갑니다. 회사명 ['" + line.split(",")[1].toString() + "']");
            }
        }
        br.close();
        return resultList;
    }

    private KoreaCompanyInfo parse(String line){
        String splitLine[] = line.split(",");
        return KoreaCompanyInfo.builder()
                .companyName(splitLine[1])
                .businessNumber(splitLine[2])
                .joinStatus(splitLine[3])
                .zipCode(splitLine[4])
                .emdFullName(splitLine[5])
                .emdCode(splitLine[7])
                .sidoCode(splitLine[9])
                .sigoonCode(splitLine[10])
                .dongCode(splitLine[11])
                .businessType(splitLine[12])
                .businessCategoryCode(splitLine[13])
                .businessCategoryName(splitLine[14])
                .build();
    }

    @Transactional
    public void saveTest(String filename){
        try {
            List<KoreaCompanyInfo> resultList = (List<KoreaCompanyInfo>) fileReadByLine(filename);
            resultList
                    .stream()
                    .parallel()
                    .forEach(koreaCompany ->{
                        try {
                            koreaCompanyInfoRepository.save(koreaCompany);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
