package net.largem.java101.collection101.map101;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMap101 {

  public static void main(String[] args) {
    final ConcurrentMap<String, Map<String, String>> map = new ConcurrentHashMap<>();

    //can't do it in one shot? putIfAbsent will return null if key does not exist.
    //map.putIfAbsent("key1", new HashMap<>()).put("innerKey1", "innerValue1");

    //this may not be a good idea to call 'put' outside of concurrent map, since the put is not protected
    map.computeIfAbsent("key1", k -> new HashMap<>()).put("innerKey1", "innerValue1");

    System.out.println(map);
  }


}
