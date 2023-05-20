package com.billlog.miribojobapi.common.public_data.company.dao.custom;

import com.billlog.miribojobapi.common.public_data.company.dto.response.KoreaCompanyInfoResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface KoreaCompanyInfoRepositoryCustom {
    Slice<KoreaCompanyInfoResponseDto> findCompanyNameListByCondition(String companyName, String sidoCode, String businessCategoryCode, Pageable pageable);
}
