package net.largem.poc.servicelocator;

public class Main {

  public static void main(String[] args) {
    ServiceA serviceA = ServiceLocator.locate(ServiceA.class, ServiceAImpl.class);

    serviceA.serviceAMethod1("abc");
  }
}
