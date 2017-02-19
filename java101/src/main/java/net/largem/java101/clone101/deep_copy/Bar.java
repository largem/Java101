package net.largem.java101.clone101.deep_copy;

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
        Bar bar = (Bar)super.clone();
        bar.fooValue_ = (Foo)fooValue_.clone();

        return bar;
    }
}
