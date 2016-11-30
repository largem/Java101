package net.largem.java101.class101;

/**
 * Created by James Tan on 11/25/2016.
 */
public class override101 {

    public static void func(String s)
    {
        System.out.println("String");
    }

    public static void func(Object o)
    {
        System.out.println("Object");
    }

    public static void main(String[] args) {
        func((Object)null);
    }
}
