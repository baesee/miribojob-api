package com.billlog.miribojobapi.common.public_data.company.dao.impl;

import com.billlog.miribojobapi.common.public_data.company.dao.custom.KoreaCompanyInfoRepositoryCustom;
import com.billlog.miribojobapi.common.public_data.company.dto.response.KoreaCompanyInfoResponseDto;
import com.billlog.miribojobapi.common.public_data.company.dto.response.QKoreaCompanyInfoResponseDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static com.billlog.miribojobapi.common.public_data.company.domain.QKoreaCompanyInfo.koreaCompanyInfo;
import static com.billlog.miribojobapi.global.utils.QueryDslPagingUtil.sliceReturnByResults;


public class KoreaCompanyInfoRepositoryImpl implements KoreaCompanyInfoRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    public KoreaCompanyInfoRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public Slice<KoreaCompanyInfoResponseDto> findCompanyNameListByCondition(String companyName, String sidoCode, String businessCategoryCode, Pageable pageable) {
        List<KoreaCompanyInfoResponseDto> results = queryFactory
                .select(new QKoreaCompanyInfoResponseDto(
                        koreaCompanyInfo.companyName,
                        koreaCompanyInfo.businessNumber,
                        koreaCompanyInfo.businessCategoryCode,
                        koreaCompanyInfo.businessCategoryName,
                        koreaCompanyInfo.emdCode,
                        koreaCompanyInfo.emdFullName,
                        koreaCompanyInfo.sidoCode,
                        koreaCompanyInfo.sigoonCode
                ))
                .from(koreaCompanyInfo)
                .where(
                        companyNameLike(companyName),
                        sidoCodeEq(sidoCode),
                        businessCategoryCodeEq(businessCategoryCode)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .orderBy(koreaCompanyInfo.companyName.asc())
                .fetch();

        return sliceReturnByResults(pageable, results);
    }

    private BooleanExpression businessCategoryCodeEq(String businessCategoryCode) {
        return StringUtils.hasText(businessCategoryCode) ? koreaCompanyInfo.businessCategoryCode.eq(businessCategoryCode) : null;
    }

    private BooleanExpression sidoCodeEq(String sidoCode) {
        return StringUtils.hasText(sidoCode) ? koreaCompanyInfo.sidoCode.eq(sidoCode) : null;
    }

    private BooleanExpression companyNameLike(String companyName) {
        return StringUtils.hasText(companyName) ? koreaCompanyInfo.companyName.contains(companyName) : null;
    }
}
