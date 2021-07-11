package net.largem.poc.builder;

public class BuilderPOC {
    public static void main(String[] args) {
        UserException exception = UserException.builder().withMessage("abc").build();

        System.out.println(exception.getMessage());

        SubUserException subUserException = SubUserException.builder()
                .withMessage("message")
                .withExtra("extra")
                .build();
        System.out.println(subUserException.getExtraMessage());

        ThirdLevelException thirdLevelException = ThirdLevelException.builder()
                .withMessage("abc")
                .withExtra("ext")
                .withCode(1)
                .build();
        System.out.println(thirdLevelException.getExtraMessage());
        System.out.println(thirdLevelException.getCode());
    }
}
