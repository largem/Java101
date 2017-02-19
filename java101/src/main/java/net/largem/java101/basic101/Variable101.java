package net.largem.java101.basic101;

/**
 * Created by James Tan on 11/25/2016.
 */
public class Variable101 {
    int x;      //member variable will be init to default value.

    public static void main(String[] args) {
        new Variable101().foo();
    }

    void foo()
    {
        //int x;        //local variable is not initialized.

        bar(++x);
    }

    void bar(int y)
    {
        int x = ++y;
        System.out.println(x);
    }
}
