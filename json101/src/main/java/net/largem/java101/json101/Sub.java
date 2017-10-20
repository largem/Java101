package net.largem.java101.json101;

/**
 * Created by plusten on 6/6/2017.
 */
public class Sub extends Base {

    int intPropSub;
    String stringPropSub;

    public Sub(int intPropBase, String stringPropBase, int intPropSub, String intPropSub1) {
        super(intPropBase, stringPropBase);
        this.intPropSub = intPropSub;
        this.stringPropSub = intPropSub1;
    }

    public int getIntPropSub() {
        return intPropSub;
    }

    public void setIntPropSub(int intPropSub) {
        this.intPropSub = intPropSub;
    }

    public String getStringPropSub() {
        return stringPropSub;
    }

    public void setStringPropSub(String stringPropSub) {
        this.stringPropSub = stringPropSub;
    }
}
