package net.largem.effectivejava.a_create_destory.item01.support;

public class Cars {

  public static Car getBMW() {
    return new BMW(50000);
  }

  private Cars() {}
}
