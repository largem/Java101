package net.largem.java101.lambda101;

import java.util.Arrays;

/**
 * Created by Administrator on 27/06/2016.
 */
public class Lambda101 {
    public static void main(String[] args) {
        basicLambdas();
        lambdasPractice2();
        lambdasPractice3();
    }

    private static void basicLambdas() {
        // Make an array containging a few Strings, and Sort it by different ways

        String[] arrStrings = {"aaa", "four", "long string", "s", "has e"};

        //sort by length
        Arrays.sort(arrStrings, (s1, s2) -> s1.length() - s2.length());
        System.out.println(Arrays.asList(arrStrings));

        //sort by reverse length
        Arrays.sort(arrStrings, (s1, s2) -> s2.length() - s1.length());
        System.out.println(Arrays.asList(arrStrings));

        //sort by alphabetically by the first charactor only
        Arrays.sort(arrStrings, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
        System.out.println(Arrays.asList(arrStrings));

        //Strings that contains "e" first.
        Arrays.sort(arrStrings, (s1, s2) -> {
            if(s1.contains("e")) {
                return -1;
            } else if (s2.contains("e")) {
                return 1;
            }
            return 0;
        });
        System.out.println(Arrays.asList(arrStrings));

        //Redo the previous problem with own method
        Arrays.sort(arrStrings, (s1, s2) -> basicLambdasHelper(s1, s2));
        System.out.println(Arrays.asList(arrStrings));
    }

    private static int basicLambdasHelper(String s1, String s2) {
        if(s1.contains("e")) {
            return -1;
        } else if (s2.contains("e")) {
            return 1;
        }
        return 0;
    }

    private static void lambdasPractice2() {
        System.out.println(betterString("Longer String", "shorter", (s1, s2) -> s1.length()>s2.length()));
    }

    private static void lambdasPractice3() {
        System.out.println(betterElement("Longer String", "shorter", (s1, s2) -> s1.length()>s2.length()));
        System.out.println(betterElement(1, 2, (i1, i2) -> i1>i2));
    }

    private static String betterString(String s1, String s2, IMyPredictor pred) {
        if (pred.apply(s1, s2)) {
            return s1;
        }
        return s2;
    }

    private static <T> T betterElement(T e1, T e2, IMyPredictorG<T> pred) {
        if (pred.apply(e1, e2)) {
            return e1;
        }
        return e2;
    }

}
