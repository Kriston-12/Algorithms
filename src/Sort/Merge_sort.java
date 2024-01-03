package Sort;

//public class Merge_sort {
//
//    public static void mergeSort(int[] arr){
//        if (arr == null || arr.length < 2){
//            return;
//        }
//        process(arr, 0, arr.length - 1);
//    }
//    public static void process(int[] arr, int l, int R) {
//        if (l == R){
//            return;
//        }
//        int mid = l + (R - l) >> 1;
//        process(arr, l, mid);
//        process(arr, mid + 1, R);
//        merge(arr, l, mid, R);
//    }
//    public static void merge(int[] arr, int l, int M, int R){
//        int[] help = new int[R - l + 1];
//        int i = 0;
//        int p1 = l;
//        int p2 = M + 1;
//        while(p1 < M && p2 < R){
//            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
//        }
//        while(p1 < M){
//            help[i++] = arr[p1++];
//        }
//        while(p2 < R){
//            help[i++] = arr[p2++];
//        }
//        for (int i = 0; i < help.length; i++) {
//          arr[l+i] = help[i];
//        }
//    }
//
//}

public class Merge_sort {
    public static void main(String[] args){
        int [] array = new int[]{3, 0, 11, 15, 18, 21, 23};
        Sort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public static void Sort(int [] array, int left, int right) {
        if (left == right){
            return;
        }
        int mid = left + (right - left) / 2;
        Sort(array, left, mid);

        Sort(array, mid + 1, right);

        merge(array, left, mid + 1, right);
    }

    static void merge(int[] arr, int leftPtr, int midBound, int rightPtr) {
         int testArray[] = new int [rightPtr - leftPtr + 1];
         int i = leftPtr;

         int h = midBound;

         int j = rightPtr;

         int k = 0;

         while(i < midBound && h <= j) {
             testArray[k++] = arr[i] <= arr[h] ? arr[i++] : arr[h++];
         }
         while(i < midBound) {
             testArray[k++] = arr[i++];
         }
         while(h <= j) {
             testArray[k++] = arr[h++];
         }

         for (int c = 0; c < testArray.length; c++ ) {
             arr[leftPtr+c] = testArray[c];
         }

    }
}

