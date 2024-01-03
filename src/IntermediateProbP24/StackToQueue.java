package IntermediateProbP24;

// Video explains sees: https://www.bilibili.com/video/BV13g41157hK/?p=24&spm_id_from=pageDriver&vd_source=d67679eb2bbd122f6cd7f6d142b724f3 第3分钟
// 用stack实现queue结构
import java.util.Stack;

public class StackToQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public StackToQueue() {
        stackPop = new Stack<>();
        stackPop = new Stack<>();
    }

    public void push(int a) {
        stackPush.push(a);
        dao();
    }

    public int poll() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException();
        }
        dao();
        return stackPop.pop();
    }

    private void dao() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }
    
}
