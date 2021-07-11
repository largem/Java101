package net.largem.poc.builder;

public class SubUserException extends UserException {

    private final String extraMessage;

    public static Builder<?> builder() {
        return new Builder<>();
    }

    protected SubUserException(Builder<?> builder) {
        super(builder);
        this.extraMessage = builder.extraMessage;
    }

    public String getExtraMessage() {
        return extraMessage;
    }

    public static class Builder<T extends Builder<T>> extends UserException.Builder<Builder<T>> {
        private String extraMessage;

        private T me() {
            return (T)this;
        }

        public T withExtra(String extraMessage) {
            this.extraMessage = extraMessage;
            return me();
        }

        public SubUserException build() {
            return new SubUserException(this);
        }
    }
}
