package IntermediateProbP21P22;

import java.util.Stack;

public class AscendedStack {
    public static void ascendedStack(Stack<Integer> stack1) {
        Stack<Integer> stack2 = new Stack<>();
        while (!stack1.isEmpty()) {
            int temp = stack1.pop();
            // Move elements from stack2 to stack1 until we find the correct position for temp
            while (!stack2.isEmpty() && stack2.peek() < temp) {
                stack1.push(stack2.pop());
            }
            stack2.push(temp);
        }

        // Move elements from stack2 back to stack1 to get the ascending order
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
}
