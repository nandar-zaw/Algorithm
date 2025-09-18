package cs425.w3_d2;

import java.util.Arrays;

public class Question3 {
    public static int[] getMergedHeap(int[] heapOne, int[] heapTwo) {
        int[] result = new int[heapOne.length + heapTwo.length];

        System.arraycopy(heapOne, 0, result, 0, heapOne.length);
        System.arraycopy(heapTwo, 0, result, heapOne.length, heapTwo.length);

        buildMaxHeap(result);
        return result;
    }

    public static void buildMaxHeap(int[] result) {
        int n = result.length;

        // We need to get the last parent node because beyond this point, everything else are already heap
        // We get that parent from n/2 - 1
        // Example: n = 7 then parent node = 7/2 - 1
        // 3 - 1 = 2, So we start from 2 index
        for (int i = n / 2 - 1; i >= 0; i--) {
            downHeap(result, i, n);
        }
    }

    public static void downHeap(int[] arr, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            swap(arr, i, largest);

            downHeap(arr, largest, n);
        }
    }

    public static void swap(int[] arr, int i, int largest) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }

    public static void main(String[] args) {
        int[] heapOne = new int[]{10, 5, 6, 2};
        int[] heapTwo = new int[]{12, 7, 9};

        System.out.println("Merged Heap: " + Arrays.toString(getMergedHeap(heapOne, heapTwo)));
    }
}
