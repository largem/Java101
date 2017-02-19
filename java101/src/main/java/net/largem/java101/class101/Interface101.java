package net.largem.java101.class101;

/**
 * Created by jamestan on 2016-07-12.
 */


interface IFoo {
	void fun();
}

class Foo implements IFoo {
	final private String value;

	public Foo(String v) {
		value = v;
	}

	public void fun() {
		//do something here
	}

	public String getValue()
	{
		return value;
	}


	@Override
	public String toString() {
		return value;
	}

}

public class Interface101
{
	public static void main( String[] args )
	{
		final IFoo foo = new Foo("abc");
		foo.fun();

		System.out.println(foo);


	}







}
