package algorithm.sort;

/**
 * @Author: zhouwei
 * @Description: 选择排序 O(n^2)
 * @Date: 2019/7/18 14:39
 * @Version: 1.0
 **/
public class SelectionSort {

    public static void main(String[] args) {
        // 测试Integer
        //Integer[] a = {10,9,8,7,6,5,4,3,2,1};
        //SelectionSort.sort(a);
        //SortHelper.printArr(a);
        //System.out.println();
        //// 测试Float
        //Float[] b = {4.4f,3.3f,2.2f,1.1f};
        //SelectionSort.sort(b);
        //SortHelper.printArr(b);
        //System.out.println();
        ////测试String
        //String[] c = {"A", "D", "B", "C"};
        //SelectionSort.sort(c);
        //SortHelper.printArr(c);
        //System.out.println();
        ////测试自定义类 Student
        //Student[] d = new Student[4];
        //d[0] = new Student("D",90);
        //d[1] = new Student("C",100);
        //d[2] = new Student("B",95);
        //d[3] = new Student("A",95);
        //SelectionSort.sort(d);
        //SortHelper.printArr(d);
        //System.out.println();
        // 随机生成数组
        //int n = 10000;
        //Integer[] arr = SortHelper.createArr(n, 100, 5000);
        //SelectionSort.sort(arr);
        //SortHelper.printArr(arr);

    }

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
        for (int i=0; i<length; i++) {
            int minIndex = i;
            for (int j=i+1; j<length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                SortHelper.swap(arr, i, minIndex);
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
