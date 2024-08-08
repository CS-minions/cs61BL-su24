public class MergeSort {


    /**
     * @param arr
     *
     * Sort the array arr using merge sort.
     * The merge sort algorithm is as follows:
     * 1. Split the collection to be sorted in half.
     * 2. Recursively call merge sort on each half.
     * 3. Merge the sorted half-lists.
     *
     */
    public static int[] sort(int[] arr) {
        // TODO: Implement merge sort
        if (arr.length <= 1) {
            return arr;
        }

        // Split the array into two halves
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // Copy data to the left and right arrays
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        // Recursively sort each half
        left = sort(left);
        right = sort(right);

        // Merge the sorted halves
        return merge(left, right);
    }

    /**
     * @param a
     * @param b
     *
     * Merge the sorted half-lists.
     *
     * Suggested helper method that will make it easier for you to implement merge sort.
     */
    private static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        // TODO: Implement merge
        int j = 0;
        int k = 0;
        int i = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        // Copy remaining elements from a, if any
        while (i < a.length) {
            c[k++] = a[i++];
        }

        // Copy remaining elements from b, if any
        while (j < b.length) {
            c[k++] = b[j++];
        }

        return c;
    }
}

