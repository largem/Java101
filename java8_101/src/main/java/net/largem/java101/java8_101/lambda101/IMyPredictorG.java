package net.largem.java101.java8_101.lambda101;

@FunctionalInterface
public interface IMyPredictorG <T>{
    boolean apply(T e1, T e2);

    //boolean apply1(T t);  //error, @FunctionalInterface prevents a second abstract method.
}
