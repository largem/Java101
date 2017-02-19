package net.largem.java101.collection101.set101;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Administrator
 */
public class Set101 {

    private class foo {
        private final String name;
        private final int value;

        public foo(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        //Note: Keep in mind, always use interface to hold the object to hide implementation details.
        Set<String> s = new HashSet<>();
        s.add("String 1");
        s.add("a String 2");
        s.add("123456");

        basicSet(s);
        newOnSet(s);

        //HashSet does not keep the order of input, LinkedHashSet does
        //Note: there is another type of Set, TreeSet, ordered by value, same as set in STL.
        Set<String> s1 = new LinkedHashSet<>();
        s1.add("String 1");
        s1.add("a String 2");
        s1.add("123456");
        System.out.println("Now try LinkedHashSet");
        newOnSet(s1);
    }

    /**
     * @param s
     */
    private static void basicSet(Set<String> s) {
        System.out.println("input set :" + s);

        //Traditional way to go through each element in a collections
        System.out.println("Iterating element using for");
        for (String e : s) {
            System.out.println(e);
        }

        System.out.println("Iterating element using iterator");
        //Note: the type of iterator is not the container, it the type of the element in the container.
        Iterator<String> it = s.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        String[] arrayString = s.toArray(new String[s.size()]);
        System.out.println("Convert set to arrary, length=" + arrayString.length);
        // Recreate array, so it won't affect the original set.
        for (String as : arrayString) {
            as = "abbcd";
        }

        System.out.println("Set contains aaa? " + s.contains("aaa"));
    }

    /**
     * @param s
     */
    private static void newOnSet(Set<String> s) {
        //Java 1.8 support forEach with lambda expression
        System.out.println("Iterating element using forEach + lambda expression");
        s.forEach(e -> System.out.println(e));

        String[] arrayString = s.stream().toArray(String[]::new);
        System.out.println("Convert set (through stream) to arrary, length=" + arrayString.length);

    }

}
