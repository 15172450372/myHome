package algorithm.sort;

/**
 * @Author: zhouwei
 * @Description: 冒泡排序 O(n^2)
 * @Date: 2019/7/18 19:12
 * @Version: 1.0
 **/
public class BubbleSort {

    /**
     * 基本思想：越大的元素会经由交换慢慢“浮”到数列的顶端
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        int length = arr.length;
        for (int i=0; i<length-1; i++) {
            for (int j=0; j<length-i-1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    SortHelper.swap(arr, j, j+1);
                }
            }
        }
    }



}
