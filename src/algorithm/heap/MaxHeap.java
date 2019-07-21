package algorithm.heap;

import algorithm.sort.SortHelper;

/**
 * @Author: zhouwei
 * @Description: 大根堆nlog(n)
 * @Date: 2019/7/21 10:40
 * @Version: 1.0
 **/
public class MaxHeap<Item extends Comparable> {

    private Item[] data;
    private int capaticy;
    private int count;

    public MaxHeap(int cap) {
        data = (Item[])new Comparable[cap+1];
        capaticy = cap;
        count = 0;
    }

    public MaxHeap(Comparable[] arr, int n) {
        data = (Item[])new Comparable[n+1];
        capaticy = n;
        for (int i=0; i<n; i++) {
            data[i+1] = (Item) arr[i];
        }
        count = n;
        for (int j=n/2; j>0; j--) {
            shiftDown(j);
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void insert(Item item) {
        assert (count<capaticy);

        data[count+1] = item;
        count++;
        shiftUp(count);
    }

    public Item extractMax() {
        Item item = data[1];
        SortHelper.swap(data, 1, count);
        count--;
        shiftDown(1);
        return item;
    }

    private void shiftUp(int index) {
        while (index/2 > 0 && data[index].compareTo(data[index/2]) > 0) {
            SortHelper.swap(data, index, index/2);
            index = index/2;
        }
    }

    private void shiftDown(int index) {
        while (2*index <= count) {
            int j = 2*index;
            if (2*index+1 <= count && data[2*index+1].compareTo(data[2*index]) > 0) {
                j = 2*index+1;
            }
            if (data[index].compareTo(data[j]) > 0) {
                break;
            }
            SortHelper.swap(data, index, j);
            index = j;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        //Integer[] arr = SortHelper.generateRandomArray(n, 0, 100);
        //MaxHeap maxHeap = new MaxHeap(n);
        //for (int i=0; i<n; i++) {
        //    maxHeap.insert(arr[i]);
        //}
        //System.out.println("..");
        //for (int i=0; i<n; i++) {
        //    System.out.println(maxHeap.extractMax());
        //}

        Integer[] arr1 = SortHelper.generateRandomArray(n, 0, 100);
        MaxHeap maxHeap1 = new MaxHeap(arr1, n);
        for (int i=0; i<n; i++) {
            System.out.println(maxHeap1.extractMax());
        }

    }



}
