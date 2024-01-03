package IntermediateProbP23;

// video see: https://www.bilibili.com/video/BV13g41157hK?p=23&vd_source=d67679eb2bbd122f6cd7f6d142b724f3 1.05h
public class SplitNBySMOp {
        public static boolean isPrime(int n) {
            if (n <= 1) {
                return false; // 1 and any negative number are not prime
            }
            if (n <= 3) {
                return true; // 2 and 3 are prime
            }
            // Check if n is divisible by 2 or 3
            if (n % 2 == 0 || n % 3 == 0) {
                return false;
            }
            // Check for prime by testing divisors from 5 to the square root of n
            for (int i = 5; i * i <= n; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true; // If no divisors are found, n is prime
        }
    // 保证n不是prime number
    // return：0) 所有因子的和，但是因子不包括1，， 1) 所有因子的个数，但是因子不包括1
    public static int[] divSumAndCount(int n) {
        int sum = 0;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                count++;
                sum += i;
                n /= i;
            }
        }
        return new int[]{sum, count};
    }

    public static int minOps(int n) {
        if(n < 2) {
            return 0;
        }
        if (isPrime(n)) {
            return n - 1;
        }
        int[] divSumAndCount = divSumAndCount(n);
        return divSumAndCount[0] - divSumAndCount[1];
    }
}
