package net.largem.lombok101;

import lombok.Data;

import javax.annotation.Nonnull;

@Data
public class DataPOJO {
    @Nonnull private Long anotherId;
    @Nonnull private String name;
}
