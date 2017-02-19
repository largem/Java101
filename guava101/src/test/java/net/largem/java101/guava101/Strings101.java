package net.largem.java101.guava101;

import com.google.common.base.Strings;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by James Tan on 11/9/2016.
 */
public class Strings101 {

    @Test
    public void example_null_empty() {
        // empty to null
        assertThat(Strings.emptyToNull(""), is(nullValue()));
        assertThat(Strings.emptyToNull(" "), is(not(nullValue())));
        assertThat(Strings.emptyToNull(null), is(nullValue()));

        // null to empty
        assertThat(Strings.nullToEmpty(null), is(""));
        assertThat(Strings.nullToEmpty(""), is(""));
        assertThat(Strings.nullToEmpty(" "), is(not("")));

        // check null or empty
        assertThat(Strings.isNullOrEmpty(null), is(true));
        assertThat(Strings.isNullOrEmpty(""), is(true));
        assertThat(Strings.isNullOrEmpty(" "), is(false));
    }

    @Test
    public void example_padding() {
        //pad end
        assertThat(Strings.padEnd("foo", 6, 'x'), is("fooxxx"));
        //won't pad if the minimum length is reached.
        assertThat(Strings.padEnd("foobar", 6, 'x'), is("foobar"));

        assertThat(Strings.padStart("foo", 6, 'x'), is("xxxfoo"));
        assertThat(Strings.padStart("foobar", 6, 'x'), is("foobar"));
    }

    @Test
    public void example_misc() {
        assertThat(Strings.repeat("abc", 2), is("abcabc"));

        assertThat(Strings.commonPrefix("abcdcba", "abccba"), is("abc"));
        assertThat(Strings.commonPrefix("abc", "bcd"), is(""));

        assertThat(Strings.commonSuffix("abcdcba", "abccba"), is("cba"));
        assertThat(Strings.commonSuffix("abc", "bcd"), is(""));
    }
}
