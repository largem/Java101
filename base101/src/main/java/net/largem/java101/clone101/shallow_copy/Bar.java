package net.largem.java101.clone101.shallow_copy;

/**
 * Created by James Tan on 2/7/2017.
 */
public class Bar implements Cloneable{
    Foo fooValue_;
    String barValue_;

    public Bar(Foo fooValue, String barValue) {
        fooValue_ = fooValue;
        barValue_ = barValue;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
