package algorithm.sort;

/**
 * @Author: zhouwei
 * @Description: 归并排序nlog(n)
 * @Date: 2019/7/19 10:20
 * @Version: 1.0
 **/
public class MergeSort {

    public static void sort(Comparable[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    /**
     * 自上向下,递归
     * @param arr
     * @param l
     * @param r
     */
    public static void mergeSort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        //优化2:对于小数组插入排序更快
        //if (r-l <= 15) {
        //    InsertSort.sort2(arr, l, r);
        //    return;
        //}
        //TODO:存在数值越界的问题
        int middle = (l+r)/2;
        mergeSort(arr, l, middle);
        mergeSort(arr, middle+1, r);
        merge(arr, l, middle, r);
        //优化1
        //if (arr[middle].compareTo(arr[middle+1]) > 0) {
        //    merge(arr, l, middle, r);
        //}

    }

    /**
     * 自底向上,迭代
     * @param arr
     */
    public static void mergeSortBU(Comparable[] arr) {
        int length = arr.length;
        for (int i=1; i<length; i+=i) {
            for (int j=0; j+i<length; j+=2*i) {
                //[j,j+i-1]、[j+i,j+i+i-1]
                merge(arr, j, j+i-1, Math.min(j+2*i-1,length-1));
            }
        }
    }

    public static void merge(Comparable[] arr, int l, int middle, int r) {
        int length = r-l+1;
        Comparable[] temp = new Comparable[length];
        int k = 0;
        int i = l;
        int j = middle+1;
        while (i <= middle && j<=r) {
            temp[k++] = arr[i].compareTo(arr[j]) <= 0 ? arr[i++] : arr[j++];
        }
        while (i <= middle) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }
        for (i=0; i<length; i++) {
            arr[l+i] = temp[i];
        }
    }

}
