package IntermediateProbP24;
//视频见 https://www.bilibili.com/video/BV13g41157hK?p=24&spm_id_from=pageDriver&vd_source=d67679eb2bbd122f6cd7f6d142b724f3 第3分钟
import java.util.Stack;

public class SpecialStack {
    public Stack<Integer> data; // 用来储存遇到的元素
    public Stack<Integer> min; // 用来更新最小元素

    public SpecialStack(int num) {
        data = new Stack<>();
        data.push(num);
        min = new Stack<>();
        min.push(num);
    }

    public void push(int num) {
        data.push(num);
        if (num < min.peek()) {
            min.push(num);
        }
        else {
            min.push(min.peek());
        }
    }

    public int getMin() {
        return min.peek();
    }
}
