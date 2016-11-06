package net.largem.java101.lambda101;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 28/06/2016.
 */
public class Utils {
    static int basicLambdasHelper(String s1, String s2) {
        if(s1.contains("e")) {
            return -1;
        } else if (s2.contains("e")) {
            return 1;
        }
        return 0;
    }

    static String betterString(String s1, String s2, IMyPredictor pred) {
        if (pred.apply(s1, s2)) {
            return s1;
        }
        return s2;
    }

    static <T> T betterElement(T e1, T e2, IMyPredictorG<T> pred) {
        if (pred.apply(e1, e2)) {
            return e1;
        }
        return e2;
    }

    static <T> List<T> allMatches(List<T> alist, Predicate<T> pred) {
        List<T> res = new ArrayList<>();

        for (T s : alist) {
            if (pred.test(s)) {
                res.add(s);
            }
        }

        return res;
    }

    static <T, R> List<R> transformedList(List<T> aList, Function<T, R> func) {
        return aList.stream().map(func).collect(Collectors.toList());
    }

    @SafeVarargs
    private static <T> Predicate<T> allPassPredicate(Predicate<T> ... preds) {
        if (preds != null && preds.length > 0) {
            Predicate<T> res = preds[0];
            for (int i=1; i<preds.length; i++) {
                res = res.and(preds[i]);
            }
            return res;
        }

        return null;
    }

    @SafeVarargs
    static <T> T firstAllMatch(Stream<T> stream, Predicate<T> ... preds) {
        Predicate<T> pred = allPassPredicate(preds);

        return pred != null ? stream.filter(pred).findFirst().orElse(null) : null;
    }

    @SafeVarargs
    private  static <T> Predicate<T> anyPassPredicate(Predicate<T> ... preds) {
        if (preds != null && preds.length > 0) {
            Predicate<T> res = preds[0];
            for (int i=1; i<preds.length; i++) {
                res = res.or(preds[i]);
            }
            return res;
        }

        return null;
    }

    @SafeVarargs
    static <T> T firstAnyMatch(Stream<T> stream, Predicate<T> ... preds) {
        Predicate<T> pred = anyPassPredicate(preds);

        return pred != null ? stream.filter(pred).findFirst().orElse(null) : null;
    }
}
