package ForcedRecursionVideo9;

import java.util.ArrayList;

public class Permutation {

    // str[i...] 范围上，所有的字符，都可以在i位置上，后续都去尝试
    // str[0...i - 1]范围上，是之前的选择
    // 把所有的字符串形成的全排列，加入到res里去
    public static void process(char[] str, int i, ArrayList<String> res) {
        if (i == str.length) {
            res.add(String.valueOf(str));
        }
        boolean[] visit = new boolean[26]; //visit[0]，[2]...,[25] 表示a,b....z是否试过，用来去掉重复， 如果str中没有重复字母，则可以不剪支
        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                process(str, i + 1, res);
                swap(str, i, j); // 再换回来, 不改变原来的str
            }
        }
    }

    public static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
