package net.largem.poc.cql.expression;

/**
 * Created by James Tan on 1/20/2017.
 */
public class VAR extends Expression{
    public static VAR PL = new VAR("?");

    private final String var_;

    public VAR(String var) {
        var_ = var;
    }

    @Override
    public String toString()
    {
        return var_;
    }
}
