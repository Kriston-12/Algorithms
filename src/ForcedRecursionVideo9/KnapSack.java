package ForcedRecursionVideo9;

@SuppressWarnings({"all"})
public class KnapSack {
    // alreadyWeight 代表之前的选择形成的重量
    // bag 代表包能承受的最大重量
    public static int process1(int[] weights, int [] values, int i, int alreadyWeight, int bag) {
        if (alreadyWeight > bag) {
            return Integer.MIN_VALUE;  // 防止上一层recursion中没有判断的超重但是让value相加的问题
        }
        if (i == weights.length) {
            return 0;
        }
        return Math.max(process1(weights, values, i + 1, alreadyWeight, bag),
                values[i] + process1(weights, values, i + 1, alreadyWeight + weights[i], bag));
    }

    public static int process2(int[] weights, int[] values, int i, int alreadyWeight, int alreadyValue, int bag) {
        if (alreadyWeight > bag) {
            return 0;
        }
        if (i == weights.length) {
            return alreadyValue;
        }
        return Math.max( process2(weights, values, i + 1, alreadyWeight, alreadyValue, bag),
                process2(weights, values, i + 1,
                        alreadyWeight + weights[i], alreadyValue + values[i], bag));
    }
}
