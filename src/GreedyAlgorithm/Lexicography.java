package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Lexicography {

    public static class MyComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }

        public static String lowestString(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            Arrays.sort(strs, new MyComparator());
            String res = "";
            for (String s : strs) {
                res += s;
            }
            return res;
        }
    }
}
