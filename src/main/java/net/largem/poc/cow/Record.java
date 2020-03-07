package net.largem.poc.cow;

import java.util.Set;

public interface Record {
    <T> T getFieldValue(Field<T> field);

    Set<Field<?>> getFields();
}
