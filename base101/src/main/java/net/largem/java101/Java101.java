package net.largem.java101;

import net.largem.java101.access101.Access101;
import net.largem.java101.class101.Class101;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

// Coming from C++, so this file contains Java specific language feature
// 
// 1. reference
// 2. const reference, how Java works with it.
// 3. Numbers, Strings
// 4. boxing
// 5. Operators
// 6. Control flow


public class Java101 {

    public static void main(String[] args) {

         //the classic start point
        System.out.println("Hello World");

        understandJavaReference();
        Class101.main(null);
        Access101.main(null);
    }



    private static void understandJavaReference() {
        //Java argument of a method/function is always pass as value
        //In Java world, everything is reference, pass reference as value means
        //+ two references *point* to the same object, both references can access the object (data+method)
        //+ Inside the function, if the reference changed its object, it won't affect the outside reference (caller).
        String s = "a String";
        System.out.println("string before pass in:" + s);
        changeArgumentInside(s);
        System.out.println("string after pass in:" + s);
    }

    private static void changeArgumentInside(String in) {
        System.out.println("pass in arg:" + in);
        in = "another string";    //String in Java is immutable, assign a string is creating a new object.
        System.out.println("change arg to: " + in);
    }
}

