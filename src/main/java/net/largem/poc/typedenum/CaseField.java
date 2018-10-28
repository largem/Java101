package net.largem.poc.typedenum;

import java.math.BigDecimal;
import java.util.List;

interface CaseField {
    SafetyField<String> NAME = SafetyField.of("ABC", ValueType.STRING);
    SafetyField<BigDecimal> NUMBER = SafetyField.of("Case Number", ValueType.NUMBER);
    SafetyField<List<String>> LIST = SafetyField.of("List", ValueType.LIST);
}

