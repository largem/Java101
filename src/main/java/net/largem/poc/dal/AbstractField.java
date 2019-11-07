package net.largem.poc.dal;

import java.util.Objects;

public abstract class AbstractField<T> implements Field<T> {

    private final String name;
    private final Class<T> type;

    public AbstractField(String name, Class<T> type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Class<T> getType() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractField<?> that = (AbstractField<?>) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
