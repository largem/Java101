package net.largem.poc.builder;

public class UserException extends Exception{

    protected UserException(Builder<?> builder) {
        super(builder.message, builder.cause);
    }

    public static Builder<?> builder() {
        return new Builder<>();
    }

    public static class Builder<T extends Builder<T>> {
        private String message;
        private Throwable cause;

        @SuppressWarnings("unchecked")
        private T me() {
            return (T)this;
        }

        public T withMessage(String message) {
            this.message = message;
            return me();
        }

        public T withCause(Throwable cause) {
            this.cause = cause;
            return me();
        }

        public UserException build() {
            return new UserException(this);
        }
    }
}
