package OrderedListAndDisjointedSet;

public class KMP {
    public static int KMP(String s, String m) { // m是否是s的子串
        if (s == null || m == null || s.length() < m.length() || s.length() < 1) { // m.length() < 1 指的是 m = ""
            return -1;
        }
        int i1 = 0;
        int i2 = 0;
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            }
            else if (next[i2] == -1){  // i2的位置已经没办法往前跳了
                i1++;
            }
            else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] {-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;  // 这两步是人为 规定
        int i = 2;
        int cn = 0;
        while (i < ms.length) {
            if (ms[i - 1] == ms[cn]) {
                next[i++] = ++cn;  // next[i] = ++cn, i++
            }
            else if (cn > 0) {
                cn = next[cn];
            }
            else {
                next[i++] = 0;
            }
        }
        return next;
    }

//    public static int[] getNextArray(String m) { version 1, on my o   wn
//        if (m.length() < 2) {
//            return new int[]{0};
//        }
//        char[] m1 = m.toCharArray();
//        int[] next = new int[m1.length];
//        int i1 = 0;  // 当前共同后缀的长度
//        int i2 = 1;
//        while (i2 < m1.length) {
//            if (m1[i1] == m1[i2]) {
//                next[i2] = i1++;
//                i2++;
//            }
//            else {
//                if (i1 == 0) {
//                    next[i2] = 0;
//                    i2++;
//                }
//                else {
//                    i1 = next[i1 - 1];
//                }
//            }
//        }
//        return next;
//    }
    public static void main(String[] args) {
        String s = "abc";
        String t = "abchbgdc";
        System.out.println(KMP(t, s));
    }
}
