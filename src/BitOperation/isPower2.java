package BitOperation;

public class isPower2 {
    public static boolean isPower2MethodOne(int n) {
        return (n & (n - 1)) == 0;  // 判断n在其32位中是否只有一个1
    }

    public static boolean isPower4(int n) {
                                      // 0x55555555 = ....10101010(4的幂数）
        return (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }

}
