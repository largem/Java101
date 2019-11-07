package net.largem.java101.generic101.container;

public interface FunctionRepository {
    <I, R> Function<I, R> getFunction(String name) throws IllegalAccessException, InstantiationException;
}
