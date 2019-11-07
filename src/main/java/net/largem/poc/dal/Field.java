package net.largem.poc.dal;

public interface Field <T>{
    String getName();

    Class<T> getType();

    T getValue(Object value);
}
