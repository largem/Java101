package net.largem.java101.generic101.wildcard101;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James Tan on 11/28/2016.
 */
public class Wildcard101 {
    @Test
    public void testPreventAddToCollection() {
        List<String> list = new ArrayList<>();

        list.add("a");
        checkElement(list, "a");
    }

    private String checkElement(List<?> list, String match) {
        //list.add("b");   //unbound wildcard make sure no addition allowed.
        list.add(null);    //only null is allowed.
        list.remove(1);

        return null;
    }



}
