package net.largem.poc.dal;

import java.util.*;

public class DynamicRecord implements Record {
    private Set<Field<?>> fields;
    private Map<Field<?>, Object> values = new HashMap<>();

    public DynamicRecord(Set<Field<?>> fields) {
        this.fields = new HashSet<>(fields);
    }

    @Override
    public <T> void setFieldValue(Field<T> field, T value) {
        if (!fields.contains(field)) {
            throw new IllegalArgumentException("unknown field " + field.getName());
        }

        values.put(field, value);
    }

    @Override
    public <T> T getFieldValue(Field<T> field) {
        if (!fields.contains(field)) {
            throw new IllegalArgumentException("unknown field " + field.getName());
        }

        return field.getValue(values.get(field));
    }
}
