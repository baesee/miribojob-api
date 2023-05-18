package com.billlog.miribojobapi.common.public_data.company.dao;

import com.billlog.miribojobapi.common.public_data.company.domain.KoreaCompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KoreaCompanyInfoRepository extends JpaRepository<KoreaCompanyInfo, Long> {
}
