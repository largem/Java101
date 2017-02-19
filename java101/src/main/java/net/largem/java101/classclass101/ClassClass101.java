package net.largem.java101.classclass101;

/**
 * Created by James Tan on 2/18/2017.
 */
public class ClassClass101 {
    public static void main(String[] args) {

        Foo foo = createInstanceByType(Foo.class);
        Bar bar = createInstanceByType(Bar.class);

        //Is this better?
        Foo foo1 = createInstanceWidely(Foo.class);
        Bar bar1 = createInstanceWidely(Bar.class);

        //create object of subclass but assign to base class reference
        Foo foo2 = createInstanceWithInherent(SubFoo.class);
        if ( foo2 instanceof SubFoo)
        {
            System.out.println("foo2 am SubFoo");
        }

        //it can also be done by this. anything is not good?
        Foo foo_1 = createInstanceByType(SubFoo.class);
        if ( foo_1 instanceof SubFoo)
        {
            System.out.println("foo_1 am SubFoo");
        }

        //and can be done by this too.
        Foo foo1_1 = createInstanceWidely(SubFoo.class);
        Object bar1_1 = createInstanceByType(Bar.class);

    }


    /**
     * call default (no-argument) constructor to create object based on its class.
     * It is useful? I saw many library use this way to create object, such as
     * Jackson deserialize json string to java object.
     * @param clazz
     * @param <T>
     * @return
     */
    private static <T> T createInstanceByType(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
        }

        return null;
    }

    /**
     * Based on Effective Java, if there is only one Type argument, replace it
     * with wild unbounded. What's the benefit?
     * @param clazz
     * @param <T>
     * @return
     */
    private static <T> T createInstanceWidely(Class<?> clazz) {
        try {
            return (T)clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
        }

        return null;
    }

    /**
     * this one restrict by Inheritance.
     * @param clazz
     * @param <T>
     * @return
     */
    private static <T> T createInstanceWithInherent(Class<? extends T> clazz)
    {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
        }

        return null;
    }


}


