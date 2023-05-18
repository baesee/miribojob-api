package com.billlog.miribojobapi.common.public_data.address.service;


import com.billlog.miribojobapi.common.public_data.address.dao.KoreaEmdCodeRepository;
import com.billlog.miribojobapi.common.public_data.address.domain.KoreaEmdCode;
import com.billlog.miribojobapi.common.public_data.address.dto.reponse.EmdInfoDto;
import com.billlog.miribojobapi.global.config.WebClientConfig;
import com.billlog.miribojobapi.global.custom.exception.BillLogBusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class KoreaEMDAddressApiService {
    /* V-WORLD 읍면동 외부 API 데이터 조회 서비스 */

    private final KoreaEmdCodeRepository koreaEmdCodeRepository;
    private final WebClientConfig webClientConfig;
    @Value("${external-service.korea-emd.baseurl}")
    String baseUrl;
    @Value("${external-service.korea-emd.key}")
    String key;

    /**
     * 읍면동 데이터를 외부 API를 통해 조회 하여 DB에 삽입한다.
     * 1000건씩 조회하여 DB에 삽입
     */
    @Transactional
    public void setEmdInfoToDB(){
        int totalEmdCount = totalEmdCount();

        if(totalEmdCount == 0){
            log.error("ERROR : [읍면동 데이터 삽입 실패] 데이터 건수 0건으로 조회 됨.");
            return;
        }

        int totalPage = 1;
        if( totalEmdCount > 1000){
            totalPage = totalEmdCount / 1000 + 1;
        }

        for ( int page = 0 ; page < totalPage ; page++){
            List<EmdInfoDto.resultRequest> fluxList = webClientConfig.webClient().get()
                    .uri(baseUrl + "?key=" + key + "&service=data" +
                            "&data=LT_C_ADEMD_INFO" +
                            "&crs=EPSG:3857" +
                            "&request=GetFeature" +
                            "&geometry=false&geomfilter=BOX(13663271.680031825,3894007.9689600193,14817776.555251127,4688953.0631258525)" +
                            "&page=" + (page + 1) + "&size=1000")
                    .retrieve()
                    .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new BillLogBusinessException("읍면동 데이터 조회시 잘못된 요청으로 인한 4XX에러 발생")))
                    .onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new BillLogBusinessException("읍면동 데이터 조회 서버 에러 발생")))
                    .bodyToFlux(EmdInfoDto.resultRequest.class)
                    .collectList()
                    .block();

            List<EmdInfoDto.resultRequest.Features> features = fluxList.get(0).getResponse().getResult().getFeatureCollection().getFeatures();

            List<KoreaEmdCode> koreaEmdCodeList = new ArrayList<>();
            for (EmdInfoDto.resultRequest.Features feature : features) {
                String emdCode = feature.getProperties().getEmdCode();
                String sidoCode = emdCode.substring(0, 2);
                String sigoonCode = emdCode.substring(2, 5);
                String dongCode = emdCode.substring(5, 8);
                String fullName = feature.getProperties().getFullName();
                String[] fullNameArray = fullName.split(" ");
                String sidoName = fullNameArray[0];
                String sigoonName = fullNameArray[1];
                String dongName = fullNameArray[2];

                koreaEmdCodeList.add(KoreaEmdCode.builder()
                        .emdCode(emdCode)
                        .sidoCode(sidoCode)
                        .sigoonCode(sigoonCode)
                        .dongCode(dongCode)
                        .sidoName(sidoName)
                        .sigoonName(sigoonName)
                        .dongName(dongName)
                        .emdFullName(fullName)
                        .deleteYn("N")
                        .build()
                );
            }
            koreaEmdCodeRepository.saveAll(koreaEmdCodeList);
        };

    }

    /**
     * 읍면동 데이터 총 건수 조회
     * @return
     */
    private int totalEmdCount(){
        EmdInfoDto.pageInfoRequest pageInfo = webClientConfig.webClient().get()
                .uri(baseUrl + "?key=" + key + "&service=data" +
                        "&data=LT_C_ADEMD_INFO" +
                        "&crs=EPSG:3857" +
                        "&request=GetFeature" +
                        "&geometry=false&geomfilter=BOX(13663271.680031825,3894007.9689600193,14817776.555251127,4688953.0631258525)" +
                        "&page=1" +
                        "&size=1")
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new BillLogBusinessException("읍면동 데이터 조회시 잘못된 요청으로 인한 4XX에러 발생")))
                .onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new BillLogBusinessException("읍면동 데이터 조회 서버 에러 발생")))
                .bodyToMono(EmdInfoDto.pageInfoRequest.class)
                .block();

        return Integer.parseInt(pageInfo.getResponse().getPage().getTotal());
    }
}
