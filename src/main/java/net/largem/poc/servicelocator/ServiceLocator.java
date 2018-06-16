package net.largem.poc.servicelocator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public final class ServiceLocator {
  private static final Map<Class<? extends Service>, Service> SERVICE_MAP = new HashMap<>();

  @SuppressWarnings("unchecked")
  public static <T extends Service, T1 extends T> T locate(Class<T> serviceClass, Class<T1> serviceImplClass ) {
    return (T) SERVICE_MAP.computeIfAbsent(serviceClass, clazz -> {
      Handler handler = new Handler(serviceImplClass);
      return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
          new Class[] {serviceClass},
          handler);
    });
  }

  private static class Handler implements InvocationHandler {
    private final Class<? extends Service> serviceClass;
    private volatile Service serviceInstance = null;

    Handler(Class<? extends Service> serviceClass) {
      this.serviceClass = serviceClass;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
        throws IllegalAccessException, IllegalArgumentException,
        InvocationTargetException, InstantiationException {

      if (serviceInstance == null) {
        serviceInstance = serviceClass.newInstance();
      }
      method.invoke(serviceInstance, args);
      return null;
    }

  }
}
