package IntermediateProblemP20___;

// 你有n个苹果，你只能用装6个苹果的袋子和8个苹果的袋子装他们，而且每个袋子必须装满。返回一个你需要用的最少袋子的数量. 如果没有此种方案，返回-1
// 视频见https://www.bilibili.com/video/BV13g41157hK?p=20&vd_source=d67679eb2bbd122f6cd7f6d142b724f3第30分钟
public class AppleMinBags {

    public static int AppleMinBags(int n) {
        if (n % 2 != 0) {   // 这里用 n & 1 != 0 会更快
            return -1;
        }
        int bag8 = n / 8;
        int bag6 = -1;
        int rest = n - bag8 * 8;
        while (rest < 24 && bag8 > 0) {  // 24 是 6和8的最小公倍数
            bag6 =  minBag6(rest);
            if (bag6 != -1) {
                break;
            }
            rest = n - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag8 + bag6;
    }

    public static int minBag6(int n) {
        return n % 6 == 0 ? n / 6 : -1;
    }

    // 打表法，观察输出的数学规律
    public static int MinBags(int n) {
        if ((n & 1) != 0) {
            return -1;
        }
        if (n < 18) {
            return n == 0 ? 0 : (n == 6) || (n == 8) ? 1 : (n == 12) || (n == 14) || (n == 16) ? 2 : -1;
        }
        return (n - 18) / 8 + 3;
    }

}
