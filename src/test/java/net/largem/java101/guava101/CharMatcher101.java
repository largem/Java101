package net.largem.java101.guava101;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import org.junit.Test;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.stream.Stream;


/**
 * Created by James Tan on 11/10/2016.
 */
public final class CharMatcher101 {

    private final static String[] STRINGS_WITH_SPACE={"AB C", "AB\tC", "AB\nC"};

    @Test
    public void example_BREAKING_WHITESPACE()
    {
        final long c = Arrays.stream(STRINGS_WITH_SPACE).filter(s -> CharMatcher.breakingWhitespace().matchesAllOf("ABC"))
                            .count();
    }
}
