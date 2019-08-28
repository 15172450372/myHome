package algorithm.sort;

/**
 * @Author: zhouwei
 * @Description: 选择排序 O(n^2)
 * @Date: 2019/7/18 14:39
 * @Version: 1.0
 **/
public class SelectionSort {

    /**
     * 基本思想：
     * 在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
     * 第二次遍历n-2个数，找到最小的数值与第二个元素交换；
     * 。。。
     * 第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        int length = arr.length;
        for (int i=0; i<length-1; i++) {
            int minIndex = i;
            for (int j=i+1; j<length-1; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                SortHelper.swap(arr, minIndex, i);
            }
        }
    }

    static class Student implements Comparable {

        private String name;
        private int source;

        public Student(String name, int source) {
            this.name = name;
            this.source = source;
        }

        @Override
        public int compareTo(Object o) {
            Student s = (Student) o;
            if (this.source > s.source) {
                return 1;
            } else if (this.source < s.source) {
                return -1;
            } else {
                return this.name.compareTo(s.name);
            }
        }
    }

}
