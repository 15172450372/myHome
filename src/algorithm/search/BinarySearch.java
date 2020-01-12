package algorithm.search;

import algorithm.sort.QuickSort;
import algorithm.sort.SortHelper;

/**
 * @Author: zhouwei
 * @Description: 二分查找
 * @Date: 2019/7/10 10:55
 * @Version: 1.0
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int N = 100;
        Integer[] arr = SortHelper.generateRandomArray(N, 0, 100);
        QuickSort.sort(arr);
        int index = search(arr, arr[5]);
        System.out.println(arr[index]);
    }

    /**
     * 二分查找
     * @param arr
     * @param target
     * @return
     */
    public static int search(Comparable[] arr, Comparable target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle].compareTo(target) == 0) {
                return middle;
            } else if (arr[middle].compareTo(target) < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }



}
