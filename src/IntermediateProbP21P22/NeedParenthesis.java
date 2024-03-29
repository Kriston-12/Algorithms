package IntermediateProbP21P22;
//一个完整的括号字符串定义规则如下：
//        ①空字符串是完整的。
//        ②如果s是完整的字符串，那么(s)也是完整的。
//        ③如果s和t是完整的宇符串，将它们连接起来形成的st也是完整的。
//        例如，"(()())",和"(())()"是完整的括号字符串，"())(","()(",")"是不完整的括号字符串。
//        牛牛有一个括号字符串s,现在需要在其中任意位置尽量少地添加括号，将其转化为一个完整的括号字符串。请问牛牛至少需要添加多少个括号。


public class NeedParenthesis {
    public static int needParenthesis(String str) {
        int count = 0; // 遇到'('，count++, 遇到')', count--. when count < 0(count = -1)，ans++,count = 0
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            }
            else {
                count--;
            }
            if(count < 0) {
                ans++;
                count = 0;
            }
        }
        return count + ans;
    }

    // 以上问题不能用Math.abs(count)的原因是："())(" 会返回0，但这不是一个完整的括号字符串，正确答案应该返回2
}
