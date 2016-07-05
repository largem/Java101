/**
 *
 */
package net.largem.java101.collection101;

import net.largem.common.Common;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Administrator
 */
public class List101 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Common.logMe(List101.class);

        usingListInterface();

        ArrayList101();

    }

    private static void usingListInterface() {
        //Create the list
        List<String> l = Arrays.asList("A", "D", "C", "B");

        //Access by position
        String s = l.get(0);
        assert Objects.equals(s, "A");

        //Get the size of list
        int sz = l.size();
        assert sz == 4;

        //change the value on postion
        String oldValue = l.set(1, "DD");
        assert oldValue == "D";

        //list is backed by an array, no element can be added or removed
        //Add one more element
        //l.add("EE");  //error, UnsupportedOperationExecption.
        //l.remove(2);

        //forEach of the list (no need stream)
        l.forEach(e -> System.out.println(e.toLowerCase()));
        l.stream().forEach(System.out::println);

        // replace the elements
        l.replaceAll(e -> e+e);

        //seatch
        boolean exist = l.contains("AA");
        assert exist;

        //get index
        int idx = l.indexOf("AA");
        idx = l.lastIndexOf("CC");

        //print list is simple
        System.out.println(l);
    }

    private static void ArrayList101() {

        String[] a1 = {"A", "D", "C", "B"};
        //Arrays.asList provides a list backed by an array
        List<String> l1 = Arrays.asList(a1);
        //List<String> l1 = Arrays.asList("A", "D", "C", "B");  //it is better, since no change to change array

        l1.stream().forEach(System.out::println);
        //if array changes its element, the list changes according.
        a1[0] = "A1";
        l1.stream().forEach(System.out::println);

        //
        List<String> l2 = new ArrayList<>();
        l2.add("A"); l2.add("D"); l2.add("C"); l2.add("B");

        l2.stream().forEach(System.out::println);


    }

}
