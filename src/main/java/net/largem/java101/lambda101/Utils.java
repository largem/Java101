package net.largem.java101.lambda101;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Administrator on 28/06/2016.
 */
public class Utils {
    public static int basicLambdasHelper(String s1, String s2) {
        if(s1.contains("e")) {
            return -1;
        } else if (s2.contains("e")) {
            return 1;
        }
        return 0;
    }

    public static String betterString(String s1, String s2, IMyPredictor pred) {
        if (pred.apply(s1, s2)) {
            return s1;
        }
        return s2;
    }

    public static <T> T betterElement(T e1, T e2, IMyPredictorG<T> pred) {
        if (pred.apply(e1, e2)) {
            return e1;
        }
        return e2;
    }

    public static <T> List<T> allMatches(List<T> alist, Predicate<T> pred) {
        List<T> res = new ArrayList<>();

        for (T s : alist) {
            if (pred.test(s)) {
                res.add(s);
            }
        }

        return res;
    }

    public static <T> List<T> transfromedList(List<T> alist, Function<T, T> func) {
        List<T> res = new ArrayList<>();

        for (T s : alist) {
            res.add(func.apply(s));
        }

        return res;
    }
}
