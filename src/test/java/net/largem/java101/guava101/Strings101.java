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
    public void test01()
    {
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
}
