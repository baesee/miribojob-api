package com.billlog.miribojobapi.global.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.billlog.miribojobapi.global.custom.exception.BillLogBusinessException;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Converter
@Configuration
public class Aes256Converter implements AttributeConverter<String, String> {

    private final Aes256Utils aes256Utils;

    public Aes256Converter() {
        this.aes256Utils = new Aes256Utils();
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        if (!StringUtils.hasText(attribute)) {
            return attribute;
        }
        try {
            return aes256Utils.encrypt(attribute);
        } catch (Exception e) {
            throw new BillLogBusinessException("failed to encrypt data");
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        try {
            return aes256Utils.decrypt(dbData);
        } catch (Exception e) {
            return dbData;
        }
    }
}
