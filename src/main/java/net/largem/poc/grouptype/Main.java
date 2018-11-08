package net.largem.poc.grouptype;

import com.google.common.collect.ImmutableList;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ValueType<String> type = CaseType.StringType.getType();
        String name = CaseType.StringType.getName();

        System.out.println("Type:" + type);
        System.out.println("Name:" + name);

        List<CaseType> list = ImmutableList.of(CaseType.NumberType, CaseType.StringType);
        list.forEach(e -> {
            System.out.println("Type:" + e.getType());
            System.out.println("Name:" + e.getName());
        });
    }

    private static final class CaseType<T> extends AbstractSafetyType<T> {
        public static CaseType<String> StringType = SafetyType.of(new TypeReference<CaseType<String>>() {
        }, "StringFieldName", ValueType.STRING);
        public static CaseType<BigDecimal> NumberType = SafetyType.of(new TypeReference<CaseType<BigDecimal>>() {
        }, "NumberFieldName", ValueType.NUMBER);
        public static CaseType<List<String>> ListType = SafetyType.of(new TypeReference<CaseType<List<String>>>() {
        }, "ListFieldName", ValueType.LIST);
    }


}
