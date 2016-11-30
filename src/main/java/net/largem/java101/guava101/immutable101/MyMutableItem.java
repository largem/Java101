package net.largem.java101.guava101.immutable101;

/**
 * Created by James Tan on 11/26/2016.
 */
public final class MyMutableItem {
    private String value_;

    public MyMutableItem(String value) {
        value_ = value;
    }

    public void setValue(String value_) {
        this.value_ = value_;
    }

    public String getValue() {
        return value_;
    }
}
