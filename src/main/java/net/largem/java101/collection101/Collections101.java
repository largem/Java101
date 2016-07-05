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

        Collection_sort_search_shuffle_fill();
    }

    private static void Collection_sort_search_shuffle_fill() {
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


}
