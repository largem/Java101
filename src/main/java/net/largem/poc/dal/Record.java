package net.largem.poc.dal;

public interface Record {
    <T> void setFieldValue(Field<T> field, T value);

    <T> T getFieldValue(Field<T> field);
}
