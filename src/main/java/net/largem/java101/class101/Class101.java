package net.largem.java101.class101;

import net.largem.common.Common;

//Cover concept in this package
//- basic class structure, constructor, member, method
//- control access to member
//- class level method
//- nested class
//- Enum type
//- interface, inheritance


public class Class101 {
    //It is very good that every class can have main function, which can run by its own, or
    //+ call by other class.
    public static void main(String[] args) {
        Common.logMe(Class101.class);
    }

    private int value;

    public Class101(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
