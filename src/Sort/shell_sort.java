package Sort;

public class shell_sort {
    public void sort(int[] arr) {
        for (int gap = arr.length >> 1; gap > 0; gap /= 2){
            for (int j = gap; j > gap - 1; j -= gap) {
                if (arr[j] < arr[j - gap]){
                    Swap(arr, j, j - gap);
                }
            }
        }
    }
    public void Swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}


