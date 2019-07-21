package algorithm.sort;

/**
 * @Author: zhouwei
 * @Description: 快速排序nlog(n)
 * @Date: 2019/7/19 15:17
 * @Version: 1.0
 **/
public class QuickSort {

    public static void main(String[] args) {
        Integer[] integers = SortHelper.generateRandomArray(100, 1, 500);
        sort(integers);

    }

    public static void sort(Comparable[] arr) {
        int length = arr.length;
        quick(arr, 0, length-1);
    }

    public static void quick(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        //优化:对于小数组插入排序更快
        //if (r-l <= 15) {
        //    InsertSort.sort2(arr, l, r);
        //    return;
        //}
        int p = partition(arr, l, r);
        quick(arr, l, p-1);
        quick(arr, p+1, r);
    }

    public static int partition(Comparable[] arr, int l, int r) {
        //优化：避免给定的序列近乎有序时任选取第一个作为中间值
        //Random random = new Random();
        //int index = random.nextInt(l + (r - l) / 2);
        //Comparable e = arr[index];
        Comparable e = arr[l];
        int j = l;
        for (int i=j+1; i<=r; i++) {
            if (arr[i].compareTo(e) < 0) {
                j++;
                SortHelper.swap(arr, j, i);
            }
        }
        SortHelper.swap(arr, l, j);
        return j;
    }

}
