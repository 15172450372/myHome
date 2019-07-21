package algorithm.sort;

import algorithm.heap.MaxHeap;

/**
 * @Author: zhouwei
 * @Description: 堆排序
 * @Date: 2019/7/21 12:28
 * @Version: 1.0
 **/
public class HeapSort {

    public static void sort(Comparable[] arr) {
        int length = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(length);
        for (int i=0; i<length; i++) {
            maxHeap.insert(arr[i]);
        }

        //MaxHeap maxHeap1 = new MaxHeap(arr, arr.length);
        //for (int i=0; i<length; i++) {
        //    maxHeap1.insert(arr[i]);
        //}
    }

}
