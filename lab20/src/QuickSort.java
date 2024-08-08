public class QuickSort {

    public static int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length);
        return arr;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end - 1) {  // Ensure there are at least two elements to sort
            int[] partitionIndices = partition(arr, start, end);
            quickSort(arr, start, partitionIndices[0]);  // Recursive call on the left part
            quickSort(arr, partitionIndices[1], end);    // Recursive call on the right part
        }
    }

    private static int[] partition(int[] arr, int start, int end) {
        int pivot =arr[start];
        int i = start + 1;
        int lt = start;
        int gt = end;

        while (i < gt) {
            if (arr[i] < pivot) {
                swap(arr, i ++, lt++);
            } else if (arr[i] > pivot) {
                swap(arr, i, --gt);
            } else {
                i++;
            }
        }
        return new int[]{lt, gt};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
