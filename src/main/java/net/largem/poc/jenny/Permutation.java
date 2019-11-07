package net.largem.poc.jenny;

import java.util.HashSet;

public class Permutation {
    public static void main(String[] args) {
        HashSet<String> result = new HashSet<>();
        String str = "CALENDAR";
        //String str = "AA";
        int n = str.length();
        Permutation permutation = new Permutation();
        permutation.permute(result, str, 0, n - 1);
        System.out.println(result.size());
    }

    private static void permute(HashSet<String> result, String str, int l, int r) {
        if (l == r) {
            if ((str.contains("CA") || str.contains("AC")) && !(str.contains("ND")||str.contains("DN"))) {
                System.out.println(str);
                result.add(str);
            }
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(result, str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    private static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
