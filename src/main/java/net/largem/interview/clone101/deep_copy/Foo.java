package net.largem.interview.clone101.deep_copy;

/**
 * Created by James Tan on 2/7/2017.
 */
public class Foo implements Cloneable{
    String value_;

    Foo(String value)
    {
        value_ = value;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
