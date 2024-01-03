package Sort;


public class QuickSort {
    public static void main(String[] args) {
        int []arr1 = {1, 3, 2, 1, 7, 6};
        quickSort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]);
        }
    }
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int p[] = partition(arr, l, r);
            quickSort(arr, l, p[0] -1 );
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;  // left boundary
        int more = r;      // right boundary
        while (l < more) {
            if (arr[l] < arr[r]){
                swap(arr, ++less, l++);
            }
            else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            }
            else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[] {less+1, more};
    }

    public static void swap(int[] arr, int i, int j){
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[j] ^ arr[i];
//        arr[i] = arr[j] ^ arr[i]; 这里不能使用此swap 因为排序时自己若i=j，则自己会和自己异或，结果一定为0
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
