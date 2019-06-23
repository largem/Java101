package net.largem.poc.typesafefield;

import java.math.BigDecimal;

interface FieldConstants {
    class RecordField<T> extends ObjectFieldImpl<T> {
        public RecordField(String name, ValueType<T> type) {
            super(name, type);
        }

        public static final RecordField<String> ID = new RecordField<>("id", ValueType.STRING);
    }

    final class CaseField<T> extends RecordField<T> {
        private CaseField(String name, ValueType<T> type) {
            super(name, type);
        }

        public static final CaseField<String> STRING_FIELD = new CaseField<>("String", ValueType.STRING);
        public static final CaseField<BigDecimal> NUMBER_FIELD = new CaseField<>("Number", ValueType.NUMBER);
    }
}


