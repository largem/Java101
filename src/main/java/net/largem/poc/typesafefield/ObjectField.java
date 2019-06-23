package net.largem.poc.typesafefield;

public interface ObjectField<T> {
    String getName();
    ValueType<T> getType();
}
