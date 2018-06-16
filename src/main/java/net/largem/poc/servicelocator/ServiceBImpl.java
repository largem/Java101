package net.largem.poc.servicelocator;

public class ServiceBImpl implements ServiceB {

  private final ServiceA serviceA = ServiceLocator.locate(ServiceA.class, ServiceAImpl.class);

  @Override
  public void serviceBMethod(int var) {
    System.out.println("This service B method B with argument " + var);
    serviceA.serviceAMethod2(var);
  }
}
