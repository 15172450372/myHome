package algorithm;

/**
 * @Descript:
 * @Author: zhouwei
 * @Date: 19-6-25 上午9:45
 * @Version 1.0
 */
public class Others {

    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        //printArrClockWise(arr);
        counterclockwise(arr);
    }

    /**
     * 顺时针输出二维数组
     * @param arr
     */
    public static void printArrClockWise(int[][] arr) {
        int circle = arr[0].length/2;
        int count = 0;
        while(count<=circle){
            //上
            for (int i=count; i<arr[count].length-count; i++) {
                System.out.print(arr[count][i] + " ");
            }
            //右
            for (int i=count+1; i<arr[count+1].length-1-count; i++) {
                System.out.print(arr[i][arr.length-1-count] + " ");
            }
            //下
            for (int i=arr.length-1-count; i>count; i--) {
                System.out.print(arr[arr.length-1-count][i] + " ");
            }
            //左
            for (int i=arr.length-1-count; i>count; i--) {
                System.out.print(arr[i][count] + " ");
            }
            count++;
        }
    }

    /**
     * 逆时针输出二维数组
     * @param arr
     */
    public static void counterclockwise(int[][] arr) {
        int circle = arr[0].length/2;
        int count = 0;
        while(count<=circle) {
            //左
            for (int i=count; i<=arr.length-1-count; i++) {
                System.out.print(arr[i][count] + " ");
            }
            //下
            for (int i=count+1; i<=arr.length-1-count; i++) {
                System.out.print(arr[arr.length-1-count][i] + " ");
            }
            //右
            for (int i=arr.length-1-count-1; i>count; i--) {
                System.out.print(arr[i][arr.length-1-count] + " ");
            }
            //上
            for (int i=arr.length-1-count; i>count; i--) {
                System.out.print(arr[count][i] + " ");
            }
            count++;
        }
    }

}
