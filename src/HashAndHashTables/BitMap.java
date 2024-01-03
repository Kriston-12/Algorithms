package HashAndHashTables;

public class BitMap {
    public static void main(String[] args) {
        int a = 0;
        // a 32 bit

        int[] arr = new int[10]; // 32bit * 10 -> 320bits  共有320bit的信息，一个bit表示一个信息
        // arr[0] int 0 - 31
        // arr[1] int 32 - 63
        // arr[2] int 64 - 95

        int i = 178; // 想取得178个bit的状态, 状态为0或1

        int numIndex = i / 32; // 获取需要在arr的哪个整数位置去取第178位
        int bitIndex = i % 32; // 获取在arr[numIndex]的第bitIndex位准确地取178位

        // 拿到第178位的状态
        int s = ((arr[numIndex] >> bitIndex) & 1);

        // 把第178位改成1
        arr[numIndex] = (arr[numIndex] | (1 << (bitIndex)));

        // 把第178位改成0
        arr[numIndex] = (arr[numIndex] & (~ (1 << bitIndex)));

    }
}
