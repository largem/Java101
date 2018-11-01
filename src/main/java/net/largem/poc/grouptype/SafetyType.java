package net.largem.poc.grouptype;
import java.lang.reflect.Field;

public interface SafetyType<T> {
    String getName();
    ValueType<T> getType();

    static <T, U extends AbstractSafetyType<T>> U of(TypeReference<U> typeReference, String name, ValueType<T> type){
        try {
            U instance = typeReference.newInstance();
            Field nameField = instance.getClass().getSuperclass().getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(instance, name);
            Field typeField = instance.getClass().getSuperclass().getDeclaredField("type");
            typeField.setAccessible(true);
            typeField.set(instance, type);
            return instance;
        }catch(Exception e) {
            return null;
        }
    }
}
