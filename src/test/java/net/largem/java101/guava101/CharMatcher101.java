package net.largem.java101.guava101;

import com.google.common.base.CharMatcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by James Tan on 11/10/2016.
 */

/**
 * CharMatcher works like a predicate to match char.
 * There are set of predefined charMatcher and a couple of operations.
  */
public final class CharMatcher101 {

    @Test
    public void example_BREAKING_WHITESPACE()
    {
        // \u00a0 is non-breaking whitespace
        final String stringWithWhiteSpace = "AB C, AB\tC, AB\nC, 100\u00a0km";

        // whitespace() matches both breaking and non-breaking whitespace.
        final String removeWhiteSpace = CharMatcher.whitespace().removeFrom(stringWithWhiteSpace);
        //final String retainWhiteSpace = CharMatcher.whitespace().retainFrom(stringWithWhiteSpace);

        // breakingWhitespace does not match non-breaking whitespace.
        final String removeBreakingWhitespace = CharMatcher.breakingWhitespace().removeFrom(stringWithWhiteSpace);
        assertThat(removeWhiteSpace, is(not(removeBreakingWhitespace)));
    }
}
