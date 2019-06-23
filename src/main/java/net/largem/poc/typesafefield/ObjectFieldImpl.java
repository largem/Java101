package net.largem.poc.typesafefield;

public abstract class ObjectFieldImpl<T> implements ObjectField<T> {
    private final String name;
    private final ValueType<T> type;

    protected ObjectFieldImpl(String name, ValueType<T> type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ValueType<T> getType() {
        return type;
    }
}
