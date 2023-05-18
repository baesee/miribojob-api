package com.billlog.miribojobapi.common.public_data.address.dao;

import com.billlog.miribojobapi.common.public_data.address.domain.KoreaEmdCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KoreaEmdCodeRepository extends JpaRepository<KoreaEmdCode, String> {
}
