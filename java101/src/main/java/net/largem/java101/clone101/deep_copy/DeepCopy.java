package net.largem.java101.clone101.deep_copy;

/**
 * Created by James Tan on 2/7/2017.
 */
public class DeepCopy {
    public static void main(String[] args) {
        Foo foo = new Foo("123");

        Bar bar1 = new Bar(foo, "cde");
        Bar bar2 = null;

        try
        {
            bar2 = (Bar)bar1.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        bar2.fooValue_.value_ = "abc";

        System.out.println(bar1.fooValue_.value_);
        System.out.println(bar2.fooValue_.value_);
    }
}
