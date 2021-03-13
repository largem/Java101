package net.largem.java101.guava101;

import com.google.common.collect.Iterators;

import java.util.Arrays;
import java.util.List;

public class Iterators101 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");

        Iterators.partition(list.iterator(), 3).forEachRemaining(p -> {
            System.out.printf("partition size: %d%n", p.size());
            p.forEach(System.out::println);
        });
    }
}
