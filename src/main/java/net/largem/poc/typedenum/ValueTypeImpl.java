package net.largem.poc.typedenum;

public class ValueTypeImpl<T> implements ValueType<T> {
    private Class<T> clazz;
    public ValueTypeImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

}
