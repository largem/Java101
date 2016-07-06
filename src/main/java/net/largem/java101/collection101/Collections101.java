package net.largem.java101.collection101;

import net.largem.common.Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jamestan on 2016-07-05.
 */
public class Collections101 {


    public static void main(String[] args) {
        Common.logMe(Collections101.class);

        //https://examples.javacodegeeks.com/core-java/util/collections/java-util-collections-example/

        Collections_sort_search_shuffle_fill();
        Collections_more();
    }

    private static void Collections_sort_search_shuffle_fill() {
        List<Double> doubles = new ArrayList<>();

        doubles.add(12.1); doubles.add(34.4); doubles.add(9.2); doubles.add(0.9); doubles.add(566.0);
        System.out.println("Original list: " + doubles);

        Collections.sort(doubles);
        System.out.println("Sorted list: " + doubles);

        int idx = Collections.binarySearch(doubles, 12.1);
        System.out.println("Find 12.1 at " + idx);

        Collections.shuffle(doubles);
        System.out.println("Shuffled list: " + doubles);

        Collections.fill(doubles, 0.0);
        System.out.println("fill 0 to list: " + doubles);
    }

    private static void Collections_more() {
        List<Double> doubles = new ArrayList<>();

        doubles.add(12.1); doubles.add(34.4); doubles.add(9.2); doubles.add(0.9); doubles.add(566.0);
        System.out.println("Original list: " + doubles);

        System.out.println("Max number in the list is " + Collections.max(doubles));
        System.out.println("Min number in the list is " + Collections.min(doubles));

        Collections.reverse(doubles);
        System.out.println("Reversed List: " + doubles);

        List<Double> newDoubles = new ArrayList<>(doubles.size());
        newDoubles.add(0.0);newDoubles.add(0.0);newDoubles.add(0.0);newDoubles.add(0.0);newDoubles.add(0.0);
        //newDoubles must has equal or bigger size
        Collections.copy(newDoubles, doubles);
        System.out.println("New list : " + newDoubles);

        Collections.replaceAll(doubles, 0.9, 99.9);
        System.out.println("List after replacement : " + doubles);
    }
}
