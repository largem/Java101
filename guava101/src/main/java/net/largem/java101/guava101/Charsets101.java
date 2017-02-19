package net.largem.java101.guava101;

import com.google.common.base.Charsets;

import java.io.UnsupportedEncodingException;

/**
 * Created by James Tan on 11/9/2016.
 */
public final class Charsets101 {

    public static void main(String[] args) {
        final Charsets101 instance = new Charsets101();
        instance.example01();   //has problem
        instance.example02();   //has problem too,
        instance.example03();   //good one

    }

    private byte[] example01()
    {
        // getBytes will use system default charsets to decode string.
        // It will have problem when the char in the string is not in the
        // charsets.
        return "string value".getBytes();
    }

    private byte[] example02()
    {
        // better than example01 by specifying the charset.
        // however, it is done by a string name, any typo will cause problem.
        try {
            return "string value".getBytes("UTF-8");
        }catch(UnsupportedEncodingException e)
        {
            return null;
        }
    }

    private byte[] example03()
    {
        // it is the right way to do.
        return "string value".getBytes(Charsets.UTF_8);
    }

}
