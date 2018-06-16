package net.largem.exp;

import java.net.URL;

public class ResourceLoadingExp {

  public static void main(String[] args) {
    URL resource = ResourceLoadingExp.class.getClassLoader()
        .getResource("resourceLoadingExp.properties");

    if (resource ==  null) {
      System.out.println("can't load resourceLoadingExp.properties");
    } else {
      System.out.println(resource);
    }

  }
}
