package net.largem.java101.guava101;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by James Tan on 11/6/2016.
 */
public class Joiner101 {
    private final static List<String> stringListWithNull =
            Collections.unmodifiableList(Arrays.asList(
                    "string1", null, "string2", "string3"));
    private final static ImmutableList<String> stringList =
            ImmutableList.of("string1", "sting2", "string3");

    @Test
    public void basicTest()
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

    private String join(final Joiner joiner, final List<String> list)
    {
        return joiner.join(list);
    }

}

