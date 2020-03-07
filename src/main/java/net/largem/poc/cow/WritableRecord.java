package net.largem.poc.cow;

public interface WritableRecord extends Record {
    <T> void setFieldValue(Field<T> field, T value);
}
