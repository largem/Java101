package net.largem.java101.streams101;

import net.largem.common.Op;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Created by Megral on 6/30/2016.
 */
public class Streams101 {
    public static void main(String[] args) {
        exercise_part1();
        exercise_part2();
        exercise_part3();
    }

    private static void exercise_part1() {
        List<String> words = Arrays.asList("hello", "thanks", "Monday", "Tuesday", "morning", "afternoon", "evening");

        /* 1
        Loop down the words and print each on a separate line, with two spaces in front of each word.
        Don’t use map.
        */
        words.stream().forEach(e-> System.out.println("  "+e));

        /* 2
        Repeat the previous problem, but without the two spaces in front. This is trivial if you use the same
        approach as in #1, so the point is to use a method reference here, as opposed to an explicit lambda
        in problem 1.
        */
        words.stream().forEach(System.out::println);

        /* 3
        In the previous exercise, we produced transformed lists like this:
        • List<String> excitingWords = StringUtils.transformedList(words, s -> s + "!");
        • List<String> eyeWords = StringUtils.transformedList(words, s -> s.replace("i", "eye"));
        • List<String> upperCaseWords = StringUtils.transformedList(words, String::toUpperCase);
        Produce the same lists as above, but this time use streams and the builtin “map” method.
        */
        System.out.println(words.stream().map(e->e+"!").collect(Collectors.toList()));
        System.out.println(words.stream().map(e->e.replace("i", "eye")).collect(Collectors.toList()));
        System.out.println(words.stream().map(String::toUpperCase).collect(Collectors.toList()));

        /* 4
         In the previous exercise, we produced filtered lists like this:
        • List<String> shortWords = StringUtils.allMatches(words, s -> s.length() < 4);
        • List<String> wordsWithB = StringUtils.allMatches(words, s -> s.contains("b"));
        • List<String> evenLengthWords = StringUtils.allMatches(words, s -> (s.length() % 2) == 0);
        Produce the same lists as above, but this time use “filter”.
        */
        System.out.println(words.stream().filter(e -> e.length()<7).collect(Collectors.toList()));
        System.out.println(words.stream().filter(e -> e.contains("o")).collect(Collectors.toList()));
        System.out.println(words.stream().filter(s -> (s.length() % 2) == 0).collect(Collectors.toList()));

        /* 5
        Turn the strings into uppercase, keep only the ones that are shorter than 7 characters, of what is
        remaining, keep only the ones that contain “O”, and print the first result. Repeat the process, except
        checking for a “N” instead of an “O”. When checking for the “N”, try to avoid repeating all the
        code from when you checked for an “O”.
        */
        /*
        System.out.println(words.stream()
                                .map(String::toUpperCase)
                                .filter(e -> e.length()<7)
                                .filter(e -> e.contains("O"))
                                .findFirst()
                                .orElse(null)
                            );
        */
        //put the above in a util function in order not to repeat the code for the second problem.
        System.out.println(Utils.firstFunnyString(words, "O"));
        System.out.println(Utils.firstFunnyString(words, "N"));

        /* 6
        The above example uses lazy evaluation, but it is not easy to see that it is doing so. Make a variation
        of the above example that proves that it is doing lazy evaluation. One way to do this is to track
        which entries are turned into upper case.
        */
        Function<String, String> toUpper = s -> {
            System.out.println("toUpper on " + s);
            return s.toUpperCase();
        };
        Predicate<String> lenthCheck = s -> {
            System.out.println("length less than 7 check");
            return s.length()<7;
        };

        Predicate<String> contains_N_Check = s -> {
            System.out.println("contains N check");
            return s.contains("N");
        };
        System.out.println(words.stream()
                .map(toUpper)
                .filter(lenthCheck)
                .filter(contains_N_Check)
                .findFirst()
                .orElse(null));

        /*
        Take one of the previous examples where you produced a List, but this time output the final result
        as an array instead of a List. This is super-easy once you know how, and the class notes show this.
        But, the syntax looks very odd when you first see it.
         */
        String[] res = words.stream().filter(e -> e.contains("o")).toArray(String[]::new);
        System.out.println(Arrays.asList(res));
    }

    private static void exercise_part2() {
        List<String> words = Arrays.asList("hello", "thanks", "Monday", "Tuesday", "morning", "afternoon", "evening");

        /*
        Produce a single String that is the result of concatenating the uppercase versions of all of the
        Strings. E.g., the result should be "HIHELLO...". Use a single reduce operation, without using map.
         */
        System.out.println(words.stream().reduce("", (s1, s2) -> s1+s2.toUpperCase()));

        /*
        Produce the same String as above, but this time via a map operation that turns the words into upper
        case, followed by a reduce operation that concatenates them.
         */
        System.out.println(words.stream().map(String::toUpperCase).reduce("", String::concat));

        /*
        Produce a String that is all the words concatenated together, but with commas in between. E.g., the
        result should be "hi,hello,...". Note that there is no comma at the beginning, before “hi”, and also no
        comma at the end, after the last word. Major hint: there are two versions of reduce discussed in the
        notes
         */
        System.out.println(words.stream().reduce((s1, s2) -> s1 + "," + s2).get());

        /*
        Find the total number of characters (i.e., sum of the lengths) of the strings in the List
         */
        System.out.println(words.stream().mapToInt(String::length).sum());

        /*
        Find the number of words that contain an “h”.
         */
        System.out.println(words.stream().filter(s->s.contains("n")).mapToInt(s->1).sum());
        System.out.println(words.stream().filter(s->s.contains("n")).count());
    }

    private static void exercise_part3() {
        /* 1
        Make a very large array of random doubles, each of which ranges from 0 to 1. A quick and easy
        way to do this is with “new Random().doubles(size).toArray()”.
         */

        double[] doubles = new Random().doubles(100_000_000).toArray();

        /* 2
        Compute the sum of the square roots of the numbers in the array. Find a shorter and simpler way
        than making a loop to tally the sum. Hint: review the notes on number-specialized streams, especially
        the fact that you make a DoubleStream from a double[] with DoubleStream.of, not Stream.of.
         */

        DoubleStream ds = DoubleStream.of(doubles);
        double sum = ds.map(d -> Math.sqrt(d)).sum();
        System.out.println("sum of 1m double's sqrt is " + sum);

        /* 3
        Repeat the process in parallel. Once you have #2 working, this should be very simple.
         */
        ds = DoubleStream.of(doubles);
        double paraSum = ds.parallel().map(d -> Math.sqrt(d)).sum();
        System.out.println("sum of 1m double's sqrt is " + paraSum);

        /* 4
        Verify that you get the “same” answer with the parallel approach as with the sequential approach.
        Why do I have “same” in quotes in the previous sentence?
         */
        System.out.println("Difference of two sums is " + (paraSum - sum));


        /* 5
        Test whether the parallel approach is faster than the sequential approach. Doing the timing is a little
        bit tedious, but if you think it simplifies things, you can steal the Op interface from streams-3-exercises
        project, then do something like this:
        Op.timeOp(() -> {
            double sum = MathUtils.sqrtSumParallel(nums);
            System.out.printf(" Sum is %,.8f.%n", sum);
        });
         */

        Op.timeOp(() -> {
            double sum1 = Utils.sqrtSum(doubles);
            System.out.printf(" Sum is %,.8f.%n", sum1);
        });

        Op.timeOp(() -> {
            double sum2 = Utils.sqrtSumParallel(doubles);
            System.out.printf(" Sum is %,.8f.%n", sum2);
        });

        /* 6
        Make an “infinite” stream that generates random doubles between 0 and 10. Use it to
        • Print 5 random doubles
        • Make a List of 10 random doubles
        • Make an array of 20 random doubles
        Note: in previous exercises, you printed an array by doing
            System.out.println(Arrays.asList(yourArray));
        This trick only works for arrays of objects, so it does not work if you have a double[], only if you
        have a Double[]. If you used Stream.generate, no problem: you have a Stream<Double>, and from
        that you can use toArray(Double[]::new) to get a Double[], then use the above trick to print the
        array. However, if you used DoubleStream.generate, you have a DoubleStream (which is not the
        same as a Stream<Double>), you can use toArray() to get a double[], but you cannot use the above
        trick to print the array. Either approach (Stream.generate or DoubleStream.generate) is fine, but if
        you use DoubleStream.generate and later produce an array, you will have to print out the elements
        with a loop of some sort.
         */

        Supplier<Double> random = Math::random;

        Stream.generate(random).map(d -> d*10).limit(5).forEach(System.out::println);
        List<Double> doubleList = Stream.generate(random).map(d -> d*10).limit(10).collect(Collectors.toList());
        System.out.println(doubleList);
        Double[] doubleArray = Stream.generate(random).map(d -> d*10).limit(20).toArray(Double[]::new);
        System.out.println(Arrays.asList(doubleArray));
    }

}
