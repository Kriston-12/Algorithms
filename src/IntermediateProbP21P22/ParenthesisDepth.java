package IntermediateProbP21P22;

public class ParenthesisDepth {
    public int parenthesisDepth(String str) {
        int count = 0;
        int maxDepth = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            }
            else {
                count--;
            }
            if (maxDepth < count) {
                maxDepth = count;
            }
        }
        return maxDepth;
    }
}
