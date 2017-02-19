package net.largem.java101.exception101;

/**
 * Created by James Tan on 11/25/2016.
 */
public class Exception101 {
    public static void main(String[] args) {
        System.out.println(func());
    }

    public static int func()
    {
        try
        {
            System.out.println("try");
            return 1;
        }
        catch(Exception e)
        {
            System.out.println("catch");
        }
        finally {
            System.out.println("finally");
            return 2;
        }
    }

}
