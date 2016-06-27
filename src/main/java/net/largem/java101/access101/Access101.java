package net.largem.java101.access101;

import net.largem.common.Common;

import java.util.Arrays;

/**
 * Created by Administrator on 22/06/2016.
 */
public class Access101 {
    final String[] arrStrings_;

    public Access101(String[] arrStrings) {
        arrStrings_ = arrStrings.clone();
        //arrStrings_ = {"some", "thing", "else"};       //error,attStrings_ is final

    }

    public String[] getStrings() {
        return arrStrings_;
    }

    public String[] getStringsNoImpactMe() {
        return arrStrings_.clone();
    }

    public static void main(String[] args) {
        Common.logMe(Access101.class);
        testFinalModifier();
    }

    private static void testFinalModifier(){
        String[] arr = { "Init", "String"};
        Access101 access101 = new Access101(arr);
        System.out.println(Arrays.toString(access101.getStrings()));

        arr[0] = "modified outside";   //change one element in the array, but it won't impact the arrStrings_ since clone
        System.out.println(Arrays.toString(access101.getStrings()));

        arr = access101.getStrings();
        arr[0] = "modified by another reference";   //change one element, final of arrStrings_ does not prevent its elements to be changed.
        System.out.println(Arrays.toString(access101.getStrings()));

        arr = access101.getStringsNoImpactMe();
        arr[0] = "Change has no impact inside";
        System.out.println(Arrays.toString(access101.getStrings()));
    }
}



