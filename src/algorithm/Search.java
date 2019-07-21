package algorithm;

/**
 * @Author: zhouwei
 * @Description: 查找
 * @Date: 2019/7/10 10:55
 * @Version: 1.0
 **/
public class Search {

    public static void main(String[] args) {

    }

    /**
     * 二分查找
     * @param arr
     * @param low
     * @param high
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int low, int high, int target) {
        while (low < high) {
            int middle = (low+high)/2;
            if (arr[middle] == target) {
                return middle;
            } else if (target > arr[middle]) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return -1;
    }



}
