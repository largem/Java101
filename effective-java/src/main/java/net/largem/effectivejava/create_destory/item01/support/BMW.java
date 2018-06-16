package net.largem.effectivejava.create_destory.item01.support;

class BMW extends Car {
  private final int value;

  BMW(int value) {
    this.value = value;
  }

  @Override
  public int getPrice() {
    return value;
  }
}
