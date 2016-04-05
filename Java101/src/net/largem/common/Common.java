package net.largem.common;

public final class Common {
	public static void logMe(Class<?> c) {
		System.out.println("Running in " + c.getSimpleName());
	}
	
	private Common(){
		throw new AssertionError();
	}
}
