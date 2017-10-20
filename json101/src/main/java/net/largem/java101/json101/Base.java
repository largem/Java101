package net.largem.java101.json101;

/**
 * Created by plusten on 6/6/2017.
 */
public class Base {
    int intPropBase;

    String stringPropBase;

    public Base(int intPropBase, String stringPropBase) {
        this.intPropBase = intPropBase;
        this.stringPropBase = stringPropBase;
    }

    public int getIntPropBase() {
        return intPropBase;
    }

    public void setIntPropBase(int intPropBase) {
        this.intPropBase = intPropBase;
    }

    public String getStringPropBase() {
        return stringPropBase;
    }

    public void setStringPropBase(String stringPropBase) {
        this.stringPropBase = stringPropBase;
    }
}
