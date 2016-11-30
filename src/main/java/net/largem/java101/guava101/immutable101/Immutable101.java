package net.largem.java101.guava101.immutable101;

import com.google.common.collect.ImmutableList;


/**
 * Created by James Tan on 11/26/2016.
 */
public final class Immutable101 {
    public static void main(String[] args) {
        ex01_shallow_copy();
    }


    /**
     * ImmutableList is just to make the list immutable, the element inside list
     * still can be modified.
     */
    private static void ex01_shallow_copy() {
        final MyMutableItem item = new MyMutableItem("value1");

        final ImmutableList<MyMutableItem> list = ImmutableList.of(item);

        System.out.println(list.get(0).getValue());

        item.setValue("value2");

        System.out.println(list.get(0).getValue());
    }
}
