package com.billlog.miribojobapi.common.public_data.company.service;

import com.billlog.miribojobapi.common.public_data.company.dao.KoreaCompanyInfoRepository;
import com.billlog.miribojobapi.common.public_data.company.dto.response.KoreaCompanyInfoResponseDto;
import com.billlog.miribojobapi.global.dto.CommonListResultDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyInfoQueryService {
    private final KoreaCompanyInfoRepository koreaCompanyInfoRepository;
    public CommonListResultDto getCompanyInfoList(String companyName, String sidoCode, String businessCategoryCode, int page){

        Slice<KoreaCompanyInfoResponseDto> companyInfoList =
                koreaCompanyInfoRepository.findCompanyNameListByCondition(companyName, sidoCode, businessCategoryCode, PageRequest.of(page - 1, 20));

        return CommonListResultDto.builder()
                .list(companyInfoList.getContent())
                .isFirst(companyInfoList.isFirst())
                .isLast(companyInfoList.isLast())
                .currentPageNumber(companyInfoList.getPageable().getPageNumber() + 1)
                .hasNext(companyInfoList.hasNext())
                .build();
    }
}
