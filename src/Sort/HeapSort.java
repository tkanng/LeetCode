
//// Java program for implementation of Heap Sort
//public class HeapSort {
//    public void sort(int arr[]) {
//        int n = arr.length;
//
//        // Build heap (rearrange array)
//        for (int i = n / 2 - 1; i >= 0; i--)
//            heapify(arr, n, i);
//
//        // One by one extract an element from heap
//        for (int i = n - 1; i >= 0; i--) {
//            // Move current root to end
//            int temp = arr[0];
//            arr[0] = arr[i];
//            arr[i] = temp;
//
//            // call max heapify on the reduced heap
//            heapify(arr, i, 0);
//        }
//    }
//
//    // To heapify a subtree rooted with node i which is
//    // an index in arr[]. n is size of heap
//    void heapify(int arr[], int n, int i) {
//        int largest = i; // Initialize largest as root
//        int l = 2 * i + 1; // left = 2*i + 1
//        int r = 2 * i + 2; // right = 2*i + 2
//
//        // If left child is larger than root
//        if (l < n && arr[l] > arr[largest])
//            largest = l;
//
//        // If right child is larger than largest so far
//        if (r < n && arr[r] > arr[largest])
//            largest = r;
//
//        // If largest is not root
//        if (largest != i) {
//            int swap = arr[i];
//            arr[i] = arr[largest];
//            arr[largest] = swap;
//
//            // Recursively heapify the affected sub-tree
//            heapify(arr, n, largest);
//        }
//    }
//
//    /* A utility function to print array of size n */
//    static void printArray(int arr[]) {
//        int n = arr.length;
//        for (int i = 0; i < n; ++i)
//            System.out.print(arr[i] + " ");
//        System.out.println();
//    }
//
//    // Driver program
//    public static void main(String args[]) {
//        int arr[] = {12, 11, 13, 5, 6, 7};
//        int n = arr.length;
//
//        HeapSort ob = new HeapSort();
//        ob.sort(arr);
//
//        System.out.println("Sorted array is");
//        printArray(arr);
//    }
//}


import java.util.Arrays;

public class HeapSort {


    public void sort(int[] arr) {
        // 升序为大顶堆
        // 根据原始的arr建立一个大顶堆，时间复杂度为O(N)
        for (int i = arr.length / 2 - 1; i >= 0; --i) {
            // 第一个非叶子节点的index为 len/2 - 1
            heapify(arr, arr.length, i);
        }
        for (int j = arr.length - 1; j > 0; --j) {
            swap(arr, 0, j);
            heapify(arr, j, 0);
        }
    }


    public void heapify(int[] arr, int len, int i) {
        // 以i节点做向下过滤操作
        int largestIdx = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < len && arr[l] > arr[largestIdx])
            largestIdx = l;
        if (r < len && arr[r] > arr[largestIdx])
            largestIdx = r;
        if (largestIdx != i) {
            swap(arr, largestIdx, i);
            heapify(arr, len, largestIdx);
        }

    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        System.out.println(Arrays.toString(arr));
    }
}
