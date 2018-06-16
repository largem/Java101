package net.largem.java101.generic101.basic;

import org.junit.Test;

public class Basic {

  @Test
  public void testGenericOverride() {
    testOverrideFunc(new DataSet<>("String"));
    testOverrideFunc(new DataSet<>(1));
  }

  /*==========*/
  private <T> void testOverrideFunc(DataSet<T> param) {
    T value = param.getValue();
    if (value instanceof String) {
      System.out.println("Dealing with String");
    } else if (value instanceof Integer) {
      System.out.println("Dealing with Integer");
    } else {
      System.out.println("Dealing with other type");
    }
  }

  private static class DataSet<T> {
    private T value;

    DataSet(T value) {
      this.value = value;
    }

    T getValue() {
      return value;
    }
  }


}
