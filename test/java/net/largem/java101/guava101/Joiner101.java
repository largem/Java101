package net.largem.java101.guava101;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by James Tan on 11/6/2016.
 */

/**
 * Joiner is to joining together a sequence of strings with a separator.
 * https://github.com/google/guava/wiki/StringsExplained#joiner
 *
 * Warning: joiner instances are always immutable. The joiner configuration methods
 * will always return a new Joiner, which you must use to get the desired semantics.
 * This makes any Joiner thread safe, and usable as a static final constant.
 */
public class Joiner101 {
    private final static List<String> stringListWithNull =
            Collections.unmodifiableList(Arrays.asList(
                    "string1", null, "string2", "string3"));
    private final static ImmutableList<String> stringList =
            ImmutableList.of("string1", "string2", "string3");

    @Test
    public void testBasic()
    {
        //if the elements to join has null in them, skipNulls must be used.
        //+ otherwise NPE will be thrown.
        assertThat(join(Joiner.on("").skipNulls(), stringListWithNull), is("string1string2string3"));
        //with delimiter
        assertThat(join(Joiner.on(",").skipNulls(), stringListWithNull), is("string1,string2,string3"));
        //transform null to other char
        assertThat(join(Joiner.on(",").useForNull(""), stringListWithNull), is("string1,,string2,string3"));

        //if the elements to join don't have null, skipNull can omit.
        assertThat(join(Joiner.on(","), stringList), is("string1,string2,string3"));
    }

    @Test(expected = NullPointerException.class)
    public void JoinerIsImmutableWrongUse()
    {
        //Joiner is immutable, so apply method will create a new Joiner.
        final Joiner aJoiner = Joiner.on("");
        aJoiner.useForNull("NULL");    //intelliJ shows the warning too.
        join(aJoiner, stringListWithNull);
        fail("should reach here");
    }

    @Test
    public void JoinerIsImmutableCorrectUse()
    {
        final Joiner joiner1 = Joiner.on("");
        final Joiner joiner2 = joiner1.useForNull("NULL");

        assertThat(join(joiner2, stringListWithNull), is("string1NULLstring2string3"));
    }

    @Test
    public void testWithStringBuilder()
    {
        final StringBuilder sb = new StringBuilder();
        sb.append("Total String:");
        final StringBuilder sb1 = Joiner.on(",").skipNulls().appendTo(sb, stringListWithNull);
        assertThat(sb.toString(), is("Total String:string1,string2,string3"));
        assertThat(sb1, is(sb));
    }

    @Test
    public void testWithAppendable() throws IOException
    {
        //Many Writers implement the Appendable interface
        //https://docs.oracle.com/javase/8/docs/api/java/lang/class-use/Appendable.html
        final StringWriter sw = new StringWriter();
        sw.write("Total String:");
        final StringWriter sw1 = Joiner.on(",").skipNulls().appendTo(sw, stringListWithNull);
        assertThat(sw.toString(), is("Total String:string1,string2,string3"));
        assertThat(sw1, is(sw));
    }

    @Test
    public void testMapJoin()
    {
        final Joiner.MapJoiner mapJoiner = Joiner.on("#").withKeyValueSeparator("=");

        final String expectString = "key1=value1#key2=value2#key3=value3";

        final ImmutableMap<String, String> map = ImmutableMap.of("key1", "value1",
                "key2", "value2", "key3", "value3");

        assertThat(mapJoiner.join(map), is(expectString));
    }


    private String join(final Joiner joiner, final List<String> list)
    {
        return joiner.join(list);
    }

}

