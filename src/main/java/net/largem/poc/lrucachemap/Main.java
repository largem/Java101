package net.largem.poc.lrucachemap;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        LRUCacheMap<Integer, String> map = new LRUCacheMap<>(10);

        HashMap<Integer, String> m = new HashMap<>();

        m.get("stting");

        for (int i=0; i<20; i++) {
            map.put(i, "Value" + i);
        }
        System.out.println("===");
        map.put(5, "new5");
        map.get(11);
        System.out.println(map.size());
        map.put(6, "new6");
    }
}
