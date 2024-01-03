package ForcedRecursionVideo9;

import java.util.Stack;

public class ReverseStackUsingRecursive {
    // 给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能使用递归函数

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        else {
            int i = f(stack);
            reverse(stack);
            stack.push(i);
        }
    }
    public static int f(Stack<Integer> stack) {  // f 压缩栈底元素并返回， eg：s = {1，2，3}， after f, s = {2, 1}, f returns 3
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }
        else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        f(s);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
