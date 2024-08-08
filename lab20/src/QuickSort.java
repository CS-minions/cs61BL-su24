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
        int pivot = arr[start];
        int i = start + 1;     // Start scanning from the element next to the pivot
        int lt = start;        // End index of the less-than-pivot section
        int gt = end;          // Start index of the greater-than-pivot section

        while (i < gt) {
            if (arr[i] < pivot) {
                swap(arr, i++, lt++);  // Increase both indices
            } else if (arr[i] > pivot) {
                swap(arr, i, --gt);  // Decrease only the gt index
            } else {
                i++;  // Move forward if equal to the pivot
            }
        }

        // Return the boundaries as: [end of less section, start of greater section]
        return new int[]{lt, gt};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
