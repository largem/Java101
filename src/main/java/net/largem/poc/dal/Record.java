package net.largem.poc.dal;

import java.util.Set;

public interface Record {
    <T> void setFieldValue(Field<T> field, T value);

    <T> T getFieldValue(Field<T> field);

    Set<Field<?>> getFields();
}
