package net.largem.java101.guava101;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by James Tan on 11/8/2016.
 */
// The Splitter class performs the inverse of the functions of the Joiner class.
// A Splitter class can split on a single character, a fixed string, a java.util.regex.Pattern package,
// a string representing a regular expression, or a CharMatcher class.
public final class Splitter101 {

    @Test
    public void testBasic()
    {
        final String testString = "Monday,Tuesday ,, Thursday ,Friday,,";

        final Splitter splitter1 = Splitter.on(",");

        final Iterable<String> parts1 = splitter1.split(testString);
        // use Iterables to get most from Iterable.
        assertThat(Iterables.size(parts1), is(7)); //contain all the empty parts
        assertThat(Iterables.get(parts1, 0), is("Monday"));
        assertThat(Iterables.get(parts1, 1), is("Tuesday "));
        assertThat(Iterables.get(parts1, 2), is(""));

        final Splitter splitter2 = splitter1.trimResults();
        final Iterable<String> parts2 = splitter2.split(testString);
        assertThat(Iterables.get(parts2, 1), is("Tuesday"));    //the ending space is trimmed.
        assertThat(Iterables.get(parts2, 3), is("Thursday"));    //both leading and ending are trimmed.

        final Splitter splitter3 = splitter1.omitEmptyStrings();
        final Iterable<String> parts3 = splitter3.split(testString);
        assertThat(Iterables.size(parts3), is(4));      // equal effect as String.split

        final Splitter splitter4 = splitter1.limit(3);
        final Iterable<String> parts4 = splitter4.split(testString);
        assertThat(Iterables.size(parts4), is(3));      // parts will be limited to 3
    }

    @Test
    public void testMapSplitter()
    {
        final String testString = "key1=value1#key2=value2";
        final Map<String, String> expected = ImmutableMap.of("key1", "value1", "key2", "value2");

        assertThat(Splitter.on("#").withKeyValueSeparator("=").split(testString), is(expected));
    }

}

