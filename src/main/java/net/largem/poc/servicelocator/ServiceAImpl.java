package net.largem.poc.servicelocator;

public class ServiceAImpl implements ServiceA {

  private final ServiceB serviceB = ServiceLocator.locate(ServiceB.class, ServiceBImpl.class);
  @Override
  public void serviceAMethod1(String var) {
    System.out.println("This is Service A Method1 with argument " + var);
    serviceB.serviceBMethod(100);
  }

  @Override
  public void serviceAMethod2(int var) {
    System.out.println("This is Service A Method2 with argument " + var);
  }
}
