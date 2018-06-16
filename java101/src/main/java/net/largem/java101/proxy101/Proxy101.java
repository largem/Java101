package net.largem.java101.proxy101;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxy101 {

  interface Original {
    void originalMethod(String s);
  }
  static class OriginalImpl implements Original {
    public void originalMethod(String s) {
      System.out.println(s);
    }
  }
  static class Handler implements InvocationHandler {
    private final Class originalClass;
    public Handler(Class originalClass) {
      this.originalClass = originalClass;
    }
    public Object invoke(Object proxy, Method method, Object[] args)
        throws IllegalAccessException, IllegalArgumentException,
        InvocationTargetException, InstantiationException {
      Object original = originalClass.newInstance();
      System.out.println("BEFORE");
      method.invoke(original, args);
      System.out.println("AFTER");
      return null;
    }
  }
  public static void main(String[] args){
    Handler handler = new Handler(OriginalImpl.class);
    Original original = (Original) Proxy.newProxyInstance(Original.class.getClassLoader(),
        new Class[] { Original.class },
        handler);
    original.originalMethod("Hello");
  }

}
