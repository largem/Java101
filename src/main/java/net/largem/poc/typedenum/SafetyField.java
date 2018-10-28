package net.largem.poc.typedenum;

public interface SafetyField<T> {
    String name();
    ValueType<T> type();

    static <T> SafetyField<T> of(String name, ValueType<T> type) {
        return new SafetyFieldImpl<>(name, type);
    }
}
