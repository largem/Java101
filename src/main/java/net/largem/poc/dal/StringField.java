package net.largem.poc.dal;

public class StringField extends AbstractField<String> {

    public StringField(String name) {
        super(name, String.class);
    }

    @Override
    public String getValue(Object value) {
        return value.toString();
    }
}
