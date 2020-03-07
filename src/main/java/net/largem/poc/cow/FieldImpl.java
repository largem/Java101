package net.largem.poc.cow;

import java.util.Objects;

public class FieldImpl<T> implements Field<T> {
    private final String name;
    private final Class<T> type;

    public FieldImpl(String name, Class<T> type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class<T> getType() {
        return type;
    }

    @Override
    public T getValue(Object value) {
        return ((T) value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldImpl<?> field = (FieldImpl<?>) o;
        return Objects.equals(name, field.name) &&
                Objects.equals(type, field.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
