package net.largem.codewar.kata.c20190629;

//https://www.codewars.com/kata/meeting?utm_source=newsletter&utm_medium=email&utm_campaign=weekly_coding_challenges&utm_term=2019-06-29
/*John has invited some friends. His list is:

s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
Could you make a program that

makes this string uppercase
gives it sorted in alphabetical order by last name.
When the last names are the same, sort them by first name. Last name and first name of a guest come in the result between parentheses separated by a comma.

So the result of function meeting(s) will be:

"(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)"
It can happen that in two distinct families with the same family name two people have the same first name too.

Notes
You can see another examples in the "Sample tests".
*/

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Meeting {
    public static void main(String[] args) {
        System.out.println(convert("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill"));
    }

    private static String convert(String input) {
        List<Name> names = StreamSupport.stream(Splitter.on(";").split(input).spliterator(), false)
                .map(s -> {
                    Iterable<String> parts = Splitter.on(":").split(s);
                    return new Name(Iterables.get(parts, 0).toUpperCase(),
                            Iterables.get(parts, 1).toUpperCase());
                }).collect(Collectors.toList());

        return names.stream()
                .sorted(Comparator.comparing(Name::getLastName).thenComparing(Name::getFirstName))
                .map(Name::toString).collect(Collectors.joining());
    }

    private static class Name {
        private final String firstName;
        private final String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return "(" + lastName + ", " + firstName + ")";
        }
    }
}

