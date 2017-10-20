package net.largem.java101.collection101.map101;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.junit.Test;

public class ConcurrentMap101 {

  @Test
  public void ConcurrentMapBasicOperation()
  {
    final ConcurrentMap<String, Map<String, String>> map = new ConcurrentHashMap<>();

    //can't do it in one shot? putIfAbsent will return null if key does not exist.
    //map.putIfAbsent("key1", new HashMap<>()).put("innerKey1", "innerValue1");

    map.computeIfAbsent("key1", k -> new HashMap<>()).put("innerKey1", "innerValue1");

    System.out.println(map);
  }


}
