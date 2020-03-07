package net.largem.effectivejava.a_create_destory.item01;

import net.largem.effectivejava.a_create_destory.item01.support.Car;
import net.largem.effectivejava.a_create_destory.item01.support.Cars;

public final class Item01_StaticFactoryMethod {

  public static void main(String[] args) {
    // Advantage 1: it has name.
    createInstanceByName();
    // Advantage 2: it is not creating instance all the time.
    notAlwaysCreate();
    // Advantage 3: it can create any subclass of the return type
    createSubType();
  }

  private static void createInstanceByName() {
    // Instead of instantiate an object by 'new', use static factory method to do so.
    StaticFactoryBasic o = StaticFactoryBasic.createMe();
  }

  static class StaticFactoryBasic {// Advantage 1: it has a name.
    public static StaticFactoryBasic createMe() {
      return new StaticFactoryBasic();
    }

    private StaticFactoryBasic() {
    }
  }

  private static void notAlwaysCreate() {
    NotAlwaysCreate o = NotAlwaysCreate.getInstance();
  }

  //Also consider FlyWeight pattern (create it and put it in cache, need lock).
  static class NotAlwaysCreate {
    private static NotAlwaysCreate instance = new NotAlwaysCreate();


    static NotAlwaysCreate getInstance() {
      return instance;
    }

    private NotAlwaysCreate() {}
  }

  private static void createSubType() {
    // subclass is hidden.
    Car car = Cars.getBMW();

    int price = car.getPrice();
  }

}
