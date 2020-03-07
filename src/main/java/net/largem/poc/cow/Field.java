package net.largem.poc.cow;

public interface Field<T> {
    String getName();
    Class<T> getType();

    T getValue(Object value);
}
