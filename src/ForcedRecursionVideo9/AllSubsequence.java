package ForcedRecursionVideo9;

import java.util.ArrayList;
import java.util.List;

// 打印字符串的全部子集
public class AllSubsequence {

//    当前来到i位置，要和不要分为两条路， res是之前的选择形成的列表
    public static void process(char[] str, int i, List<Character> res) {
        if (i == str.length) {
            printList(res);
            return;
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(str[i]); // 选择要当前位置的字符
        process(str, i + 1, resKeep);
        List<Character> resNoInclude = copyList(res);  // 不要当前字符
        process(str, i + 1, resNoInclude);

    }

    public static void printList(List<Character> res) {
        for (char ch : res) {
            System.out.print(ch + " ");
        }
    }

    public static List<Character> copyList(List<Character> res) {
        return new ArrayList<>(res);
    }

    //方法2 更省空间
    public static void process1(char[] str, int i) {
        if (i == str.length) {
            System.out.println(str); //Both System.out.println() and System.out.print() treat a char[] as
            // a sequence of characters and automatically convert it to a String representation for output.

//            System.out.println(String.valueOf(str)); this is another print method
        }
        process1(str, i + 1); // 要当前字符的path
        char temp = str[i];
        str[i] = 0;
        process1(str, i + 1);  // 不要当前字符的path
        str[i] = temp;
    }
}
