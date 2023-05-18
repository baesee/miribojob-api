package com.billlog.miribojobapi.common.public_data.address.dto.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class EmdInfoDto {
    @Getter
    @Setter
    public static class pageInfoRequest{
        @JsonProperty("response")
        private Response response;
        @Getter
        @Setter
        public static class Response {
            @JsonProperty("page")
            private Page page;
        }
        @Getter
        @Setter
        public static class Page {
            private String total;
            private String current;
            private String size;
        }
    }

    @Getter
    @Setter
    public static class resultRequest{
        @JsonProperty("response")
        private Response response;
        @Getter
        @Setter
        public static class Response {
            @JsonProperty("result")
            private Result result;
        }
        @Getter
        @Setter
        public static class Result {
            @JsonProperty("featureCollection")
            private FeatureCollection featureCollection;
        }
        @Getter
        @Setter
        public static class FeatureCollection {
            @JsonProperty("features")
            private List<Features> features;
            //private List<Features> features;
        }
        @Getter
        @Setter
        @ToString
        public static class Features {
            @JsonProperty("properties")
            private Properties properties;
        }
        @Getter
        @Setter
        @ToString
        public static class Properties {
            @JsonProperty("full_nm")
            private String fullName;
            @JsonProperty("emd_kor_nm")
            private String emdKorName;
            @JsonProperty("emd_cd")
            private String emdCode;
        }
    }
}
