package algorithm.sort;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/7/18 15:16
 * @Version: 1.0
 **/
public class SortHelper {

    public static void main(String[] args) {
        int N = 10;
        Integer[] arr = SortHelper.generateRandomArray(N, 0, 1000);
        //SortHelper.testSort("algorithm.sort.SelectionSort", arr);
        //SortHelper.testSort("algorithm.sort.InsertSort", arr);
        //SortHelper.testSort("algorithm.sort.BubbleSort", arr);
        //SortHelper.testSort("algorithm.sort.ShellSort", arr);
        //SortHelper.testSort("algorithm.sort.MergeSort", arr);
        //SortHelper.testSort("algorithm.sort.QuickSort", arr);

    }

    /**
     * 交换
     * @param arr
     * @param i 下标
     * @param j 下标
     */
    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void printArr(Comparable[] arr) {
        int length = arr.length;
        for( int i = 0 ; i < length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    /**
     * 生成随机数组
     * @param n 个数
     * @param rangeL 左边界
     * @param rangeR 右边界
     * @return
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i=0; i<n; i++) {
            int rangeNum = random.nextInt(rangeR);
            if (rangeNum < rangeL) {
                rangeNum = random.nextInt(rangeR);
            }
            arr[i] = rangeNum;
        }
        return arr;
    }

    /**
     * 测试排序的正确性
     * @return
     */
    public static boolean isSorted(Comparable[] arr) {
        int length = arr.length;
        for (int i=0; i<length-1; i++) {
            if (arr[i].compareTo(arr[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
     * @param sortClassName
     * @param arr
     */
    public static void testSort(String sortClassName, Comparable[] arr){
        // 通过Java的反射机制，通过排序的类名，运行排序函数
        try {
            Class<?> sortClass = Class.forName(sortClassName);
            Method sort = sortClass.getMethod("sort", Comparable[].class);

            long startTime = System.currentTimeMillis();
            sort.invoke(null, (Object) arr);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);

            System.out.println( sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms" );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
