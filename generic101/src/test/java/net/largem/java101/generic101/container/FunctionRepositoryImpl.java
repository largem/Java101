package net.largem.java101.generic101.container;

import java.util.HashMap;
import java.util.Map;

public class FunctionRepositoryImpl implements FunctionRepository {
    private static final Map<String, Class<? extends Function>> repo = new HashMap<>();

    static {
        addFunction("stringFunction",  StringFunction.class);
    }

    @Override
    public <I, R> Function<I, R> getFunction(String name) throws IllegalAccessException, InstantiationException {
        Class<? extends Function> clazz = repo.get(name);
        return (Function<I, R>)(clazz.newInstance());
    }

    private static void addFunction(String name, Class<? extends Function> functonClass) {
        repo.put(name, functonClass);
    }
}
