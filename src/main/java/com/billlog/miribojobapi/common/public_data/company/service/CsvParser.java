package com.billlog.miribojobapi.common.public_data.company.service;

import com.billlog.miribojobapi.common.public_data.company.domain.KoreaCompanyInfo;

public interface CsvParser<T> {
    KoreaCompanyInfo parse(String str);
}
