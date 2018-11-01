package net.largem.poc.grouptype;

import java.math.BigDecimal;

public final class CaseType<T> extends AbstractSafetyType<T> {
    public static CaseType<String> StringType = SafetyType.of(new TypeReference<CaseType<String>>() {
    }, "StringFieldName", ValueType.STRING);
    public static CaseType<BigDecimal> NumberType = SafetyType.of(new TypeReference<CaseType<BigDecimal>>() {
    }, "NumberFieldName", ValueType.NUMBER);
}
