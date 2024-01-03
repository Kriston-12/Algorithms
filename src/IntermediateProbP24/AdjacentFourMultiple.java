package IntermediateProbP24;
// videos see https://www.bilibili.com/video/BV13g41157hK?p=24&vd_source=d67679eb2bbd122f6cd7f6d142b724f3 1:50
public class AdjacentFourMultiple {
    public static boolean calc(int[] arr) {
        int count2Multiple = 0;
        int count4Multiple = 0;
        int countOdd = 0;
        for (int i : arr) {
            if (i % 4 == 0) {
                count4Multiple++;
            }
            else if (i % 2 == 0) {
                count2Multiple++;
            }
            else {
                countOdd++;
            }
        }
        if (count2Multiple == 0) {
            return count4Multiple >= countOdd - 1;
        }
        else {
            return count4Multiple >= countOdd;
        }
    }
}
