package net.largem.java101.java8_101.streams101;

import com.google.common.collect.Iterators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class LazyPartitionStream {

    public static void main(String[] args) {
        IntStream s = IntStream.range(0, 100);

        List<Con> consumers = new ArrayList<>();
        consumers.add(new Con("con1"));
        consumers.add(new Con("con2"));

        Iterators.partition(s.iterator(), 10).forEachRemaining(ll -> {
            for (Con c : consumers) {
                c.add(() -> {
                    System.out.println(String.format("%s:%s", c.name, c.con));
                    return ll;
                });
            }
        });

        for (Con c : consumers) {
            List<Supplier<List<Integer>>> ss = c.con;
            ss.stream().forEach(supplier -> {
                supplier.get().stream().forEach(System.out::println);
            });
        }
    }

    private static class Con {
        private final List<Supplier<List<Integer>>> con = new ArrayList<>();
        private final String name;

        public Con(String name) {
            this.name = name;
        }

        public void add(Supplier<List<Integer>> c) {
            con.add(c);
        }
    }
}
