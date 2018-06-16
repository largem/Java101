package net.largem.java101.json102.dload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sub102 implements JsonBindable {

  private final String strValue;

  private final int intValue;

  @JsonCreator
  public Sub102(@JsonProperty("strValue") String strValue, @JsonProperty("intValue") int intValue) {
    this.strValue = strValue;
    this.intValue = intValue;
  }

  public String getStrValue() {
    return strValue;
  }

  public int getIntValue() {
    return intValue;
  }

  @Override
  public String toString() {
    return "Sub102{" +
        "strValue='" + strValue + '\'' +
        ", intValue=" + intValue +
        '}';
  }
}
