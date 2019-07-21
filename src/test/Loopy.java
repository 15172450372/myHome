package test;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/7/15 20:32
 * @Version: 1.0
 **/
public class Loopy {
    public static void main(String[] args) {
        final int start = Integer.MAX_VALUE - 100;
        final int end = Integer.MAX_VALUE;
        int count = 0;
        for (int i = start; i <= end; i++) {
            count++;
        }
        System.out.println(count);
    }
}
