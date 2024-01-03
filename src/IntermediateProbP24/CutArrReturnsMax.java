package IntermediateProbP24;
// video sees https://www.bilibili.com/video/BV13g41157hK/?p=24&spm_id_from=pageDriver&vd_source=d67679eb2bbd122f6cd7f6d142b724f3 57min
public class CutArrReturnsMax {
    public static int returnsMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return Math.max(max - arr[0], max - arr[arr.length - 1]);
    }
}
