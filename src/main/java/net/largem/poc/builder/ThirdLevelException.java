package net.largem.poc.builder;

public final class ThirdLevelException extends SubUserException {
    private final int code;

    public static ThirdBuider builder() {
        return new ThirdBuider();
    }

    private ThirdLevelException(ThirdBuider builder) {
        super(builder);
        this.code = builder.code;
    }

    public int getCode() {
        return code;
    }

    public static final class ThirdBuider extends SubUserException.Builder<ThirdBuider> {
        private int code;

        public ThirdBuider withCode(int code) {
            this.code = code;
            return this;
        }

        public ThirdLevelException build() {
            return new ThirdLevelException(this);
        }
    }
}
