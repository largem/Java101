package net.largem.poc.cow;

import java.util.*;

public class RecordUpdate implements WritableRecord {
    private Record originalRecord;
    private Map<Field<?>, Object> updates = new HashMap<>();

    public RecordUpdate() {
        originalRecord = new EmptyRecord();
    }

    public RecordUpdate(Record originalRecord) {
        this.originalRecord = originalRecord;
    }

    @Override
    public <T> void setFieldValue(Field<T> field, T value) {
        updates.put(field, value);
    }

    @Override
    public <T> T getFieldValue(Field<T> field) {
        if (updates.containsKey(field)) {
            return field.getValue(updates.get(field));
        }
        return originalRecord.getFieldValue(field);
    }

    @Override
    public Set<Field<?>> getFields() {
        Set<Field<?>> fields = new HashSet<>(originalRecord.getFields());
        fields.addAll(updates.keySet());
        return fields;
    }

    private static class EmptyRecord implements Record{
        @Override
        public <T> T getFieldValue(Field<T> field) {
            return null;
        }

        @Override
        public Set<Field<?>> getFields() {
            return Collections.emptySet();
        }
    }
}
