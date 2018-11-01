package net.largem.poc.grouptype;

public abstract class AbstractSafetyType<T> implements SafetyType<T> {

    private String name;
    private ValueType<T> type;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ValueType<T> getType() {
        return type;
    }
}
