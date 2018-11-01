package net.largem.poc.grouptype;

import java.math.BigDecimal;
import java.util.List;

public interface ValueType<T> {
    ValueType<String> STRING = new ValueTypeImpl<>(String.class);

    ValueType<BigDecimal> NUMBER = new ValueTypeImpl<>(BigDecimal.class);

    ValueType<List<String>> LIST = new ValueTypeImpl(List.class);
}
