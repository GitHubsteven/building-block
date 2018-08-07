package divdeandconquer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/26
 * @Time: 10:37
 * @Description:
 * @version: 1.0.0
 */
/* Java program for Merge Sort */
class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[left..m]
    // Second subarray is arr[m+1..right]
    void merge(int arr[], int left, int m, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = m - left + 1;
        int n2 = right - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[left..right] using
    // merge()
    void sort(int arr[], int left, int right) {
        if (left < right) {
            // Find the middle point
            int m = (left + right) / 2;

            // Sort first and second halves
            sort(arr, left, m);
            sort(arr, m + 1, right);

            // Merge the sorted halves
            merge(arr, left, m, right);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7,7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}