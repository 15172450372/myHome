package algorithm.sort;

/**
 * @Author: zhouwei
 * @Description: 插入排序（在近乎有序的情况下效率高O(n)）
 * @Date: 2019/7/18 16:51
 * @Version: 1.0
 **/
public class InsertSort {

    public static void main(String[] args) {
        int n = 10;
        Integer[] arr = SortHelper.generateRandomArray(n, 10, 50);
        sort(arr);
        SortHelper.printArr(arr);
    }

    public static void sort(Comparable[] arr) {
        int length = arr.length;
        //for (int i=0; i<length; i++) {
        //    for (int j=i; j>0; j--) {
        //        if (arr[j].compareTo(arr[j-1]) < 0) {
        //            SortHelper.swap(arr, j, j-1);
        //        } else {
        //            break;
        //        }
        //    }
        //}
        //优化：减少交换次数
        for (int i=0; i<length; i++) {
            Comparable e = arr[i];
            int j;
            for (j=i; j>0; j--) {
                if (arr[j-1].compareTo(e)>0) {
                    arr[j] = arr[j-1];
                }
            }
            arr[j] = e;
        }
    }

    public static void sort2(Comparable[] arr, int l, int r) {
        for (int i=l; i<r; i++) {
            Comparable e = arr[i];
            int j;
            for (j=i; j>l; j--) {
                if (e.compareTo(arr[j-1]) < 0) {
                    arr[j] = arr[j-1];
                }
            }
            arr[j] = e;
        }
    }


}
