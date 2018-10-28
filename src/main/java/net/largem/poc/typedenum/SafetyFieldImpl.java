package net.largem.poc.typedenum;

public class SafetyFieldImpl<T> implements SafetyField<T> {
    private final String name;
    private final ValueType<T> type;

    public SafetyFieldImpl(String name, ValueType<T> type)  {
        this.name = name;
        this.type = type;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public ValueType<T> type() {
        return type;
    }
}
