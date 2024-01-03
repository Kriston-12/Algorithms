package Leetcode_exercises;
import java.util.HashMap;
import java.util.Map;

public class Climbing_stairs_e {
    public int climbStairsRecursively(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairsRecursively(n - 1) + climbStairsRecursively(n - 2);
    }

    private Map<Integer, Integer> storeMap = new HashMap<>();
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(null != storeMap.get(n))
            return storeMap.get(n);
        else {
            int result = climbStairs(n - 1) + climbStairs(n - 2);
            storeMap.put(n, result);
            return result;
        }
    }
/*    class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int result = 0;
        int pre = 2;
        int prePre = 1;
        for (int i = 3; i <= n; ++i){
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }

}*/
}

