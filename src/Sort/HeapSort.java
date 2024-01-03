package Sort;


// 大根堆：每一棵子树的最大值是头节点的值
// 小根堆：每一颗子树的最小值是头节点的值
public class HeapSort {
    public static void main(String arg[]){
        int[] arr1 = {11, 2, 5, 26, 99, 47};
        heapSort(arr1);
        for(int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }
    public static void heapSort(int arr[]){
        if (arr == null || arr.length < 2){
            return;
        }
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }
        for (int i = arr.length / 2 - 1; i >= 0; i--){
            heapify(arr, i, arr.length);          // 复杂度与以上代码相同，但是第一步会快一点
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }


    // 某个数现在在index位置，往上继续移动
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index-1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 某个数现在在index位置，往下继续移动
    public static void heapify(int [] arr, int index, int heapSize) {
        heapSize--;     // I wonder why
        int left = 2 * index + 1;
        while(left + 1 < heapSize) {
            int largest = arr[left] > arr[left + 1] ? left : (left + 1);
            largest = arr[index] > arr[largest] ? index : largest;
            if (index == largest) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }
    public static void swap(int [] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
