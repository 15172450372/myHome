package algorithm.sort;

/**
 * @Author: zhouwei
 * @Description: 希尔排序O（nlogn）～O（n2）
 * @Date: 2019/7/18 19:32
 * @Version: 1.0
 **/
public class ShellSort {

    public static void sort(Comparable[] arr) {
        int length = arr.length;
        int d = length;  //增量
        while (true) {
            d = d/3;
            //插入排序
            for (int i=0; i<d; i++) {
                for (int j=i+d; j<length; j+=d) {
                    if (arr[j].compareTo(arr[j-d]) < 0) {
                        SortHelper.swap(arr, j, j-d);
                    } else {
                        break;
                    }
                }
            }
            if (d == 1) {
                break;
            }
        }
    }

}
