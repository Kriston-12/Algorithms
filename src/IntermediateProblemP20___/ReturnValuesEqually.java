package IntermediateProblemP20___;

public class ReturnValuesEqually {
    public static int f() {         // this is the given function that you cannot change
        return (int)(Math.random() * 5) + 1;
    }

    public static int r01() {       //根据f()，等慨率返回0或1
        int res = 0;
        do {
            res = f();
        } while (res == 3);
        return res < 3 ? 0 : 1;
    }

    public static int g() {  // 一个返回1-7的函数
        int res = 0;
        do {
            res = r01() << 2 + r01() << 1 + r01();
        } while (res == 7);
        return res + 1;
    }
}
