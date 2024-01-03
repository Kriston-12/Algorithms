package Sort;

import java.util.ArrayList;
import java.util.List;

public class MergeCountOfSmallerNumbersAfterSelf {
//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//        if (nums.length < 2) {
//            return nums;
//        }
//    }

//    public int[] countSmaller1(int[] nums) {
//        if (nums.length < 2) {
//            return nums;
//        }
//        return
//    }
//
//    public int[] process(int[] arr, int l, int r) {
//        if (l == r) {
//            return null;
//        }
//        int mid = l + (r - l) >> 1;
////        return process(arr, l, mid) +
////                process(arr, mid + 1, r) +
////                merge()
//    }
//
//    public static int[] merge(int[] arr, int l, int m, int r) {
//        int p1 = 0;
//        int p2 = m + 1;
//        int[] help = new int[r - l + 1];
//        int[] pair;
//
//    }

//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> counts = new ArrayList<>();
//        int[] sorted = new int[nums.length];
//        int[] indexes = new int[nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            indexes[i] = i;
//            counts.add(0);
//        }
//
//        mergeSort(nums, indexes, counts, sorted, 0, nums.length - 1);
//
//        return counts;
//    }
//
//    private void mergeSort(int[] nums, int[] indexes, List<Integer> counts, int[] sorted, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//
//        int mid = left + (right - left) / 2;
//        mergeSort(nums, indexes, counts, sorted, left, mid);
//        mergeSort(nums, indexes, counts, sorted, mid + 1, right);
//        merge(nums, indexes, counts, sorted, left, mid, right);
//    }
//
//    private void merge(int[] nums, int[] indexes, List<Integer> counts, int[] sorted, int left, int mid, int right) {
//        int i = left;
//        int j = mid + 1;
//        int k = left;
//        int smallerCount = 0;
//
//        while (i <= mid && j <= right) {
//            if (nums[indexes[i]] <= nums[indexes[j]]) {
//                counts.set(indexes[i], counts.get(indexes[i]) + smallerCount);
//                sorted[k++] = indexes[i++];
//            } else {
//                sorted[k++] = indexes[j++];
//                smallerCount++;
//            }
//        }
//
//        while (i <= mid) {
//            counts.set(indexes[i], counts.get(indexes[i]) + smallerCount);
//            sorted[k++] = indexes[i++];
//        }
//
//        while (j <= right) {
//            sorted[k++] = indexes[j++];
//        }
//
//        for (int m = left; m <= right; m++) {
//            indexes[m] = sorted[m];
//        }
//    }

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>(len);
        int[] index = new int[len];
        for (int i = 0; i < len; i++){
            index[i] = i;
        }
        int[] temp = new int[len];
        int[] ans = new int[len];
        countSmaller(nums, 0, len - 1, index, temp, ans);
        for(int i = 0; i < len; i++){
            res.add(ans[i]);
        }
        return res;
    }

    private void countSmaller(int[] nums, int left, int right, int[] index, int[] temp, int[] ans){
        if (left == right) return;

        int mid = left + (right - left) >> 2;
        countSmaller(nums, left, mid, index, temp, ans);
        countSmaller(nums, mid + 1, right, index, temp, ans);
        if (nums[index[mid]] <= nums[index[mid + 1]]) return;
        mergesort(nums, left, mid, right, index, temp, ans);
        return;
    }

    private void mergesort(int[] nums, int left, int mid, int right, int[] index, int[] temp, int[] ans){
        for (int i = left; i <= right; i++){
            temp[i] = index[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++){
            if (i == mid + 1){
                index[k] = temp[j];
                j++;
            }
            else if (j == right + 1){
                index[k] = temp[i];
                i++;
                ans[index[k]] += (right - mid);
            }
            else if (nums[temp[i]] <= nums[temp[j]]){
                index[k] = temp[i];
                i++;
                ans[index[k]] += (j - mid - 1);
            }
            else if (nums[temp[i]] > nums[temp[j]]){
                index[k] = temp[j];
                j++;
            }
        }
    }
}
