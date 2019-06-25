package algorithm;


/**
 * @Descript: 排序
 * @Author: zhouwei
 * @Date: 19-6-16 上午9:55
 * @Version 1.0
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = {1,2,100,68,46,17,3,5,9,18,7,64};
        //bubbleSort(arr);
        //quickSort(arr,0,arr.length-1);
        //insertSort(arr);
        int[] ints = mergeSort(arr, 0,arr.length - 1);
        print(ints);
    }

    /**
     * 打印结果
     * @param arr
     */
    public static void print(int[] arr) {
        for (int i:arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 冒泡排序
     * 基本思想：越大的元素会经由交换慢慢“浮”到数列的顶端
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int tem = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tem;
                }
            }
        }
    }

    /**
     * 快速排序
     * 基本思想：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
     * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
     * @param arr
     * @param low 最小下标
     * @param high 最大下标
     */
    public static void quickSort(int[] arr, int low, int high) {
        int l = low;
        int h = high;
        int key = arr[low];
        while (l < h) {
            while (arr[h] > key) {
                h--;
            }
            if (arr[h] < key) {
                int tem = arr[l];
                arr[l] = arr[h];
                arr[h] = tem;
            }
            while (arr[l] < key) {
                l++;
            }
            if (arr[l] > key) {
                int tem = arr[l];
                arr[l] = arr[h];
                arr[h] = tem;
            }
        }
        if (l-1 > low) {
            quickSort(arr,low,l-1);
        }
        if (h+1 < high) {
            quickSort(arr,h+1,high);
        }
    }

    /**
     * 插入排序
     * 基本思想：每步将一个待排序的记录，按其关键码值的大小插入前面已经排序的文件中适当位置上，直到全部插入完为止
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i=1; i<arr.length-1; i++) {
            for (int j=i+1; j>0; j--) {
                if (arr[j] < arr[j-1]) {
                    int tem = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tem;
                }
            }
        }
    }

    /**
     * 归并排序
     * @param arr
     * @param low
     * @param high
     */
    public static int[] mergeSort(int[] arr, int low, int high) {
        if (low == high) {
            return new int[]{arr[low]};
        }
        int mid = low + (high - low) / 2;
        int[] leftArr = mergeSort(arr, low, mid); //左有序数组
        int[] rightArr = mergeSort(arr, mid + 1, high); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组

        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length) {
            newNum[m++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            newNum[m++] = rightArr[j++];
        }
        return newNum;
    }

}
