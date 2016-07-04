package net.largem.java101.streams101;

import java.util.List;
import java.util.stream.DoubleStream;

/**
 * Created by Megral on 7/4/2016.
 */
public class Utils {
    public static String firstFunnyString(List<String> words, String containedTest) {
        String res = words.stream().map(String::toUpperCase)
                                   .filter(s -> s.length() < 7)
                                   .filter(s -> s.contains(containedTest))
                                   .findFirst()
                                   .orElse(null);
        return res;
    }

    public static double sqrtSum(double[] doubles) {
        DoubleStream ds = DoubleStream.of(doubles);
        return ds.parallel().map(d -> Math.sqrt(d)).sum();
    }

    public static double sqrtSumParallel(double[] doubles) {
        DoubleStream ds = DoubleStream.of(doubles);
        return ds.parallel().map(d -> Math.sqrt(d)).sum();
    }
}
