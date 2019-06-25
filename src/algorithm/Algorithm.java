package algorithm;

/**
 * @Descript:
 * @Author: zhouwei
 * @Date: 19-6-25 上午9:33
 * @Version 1.0
 */
public class Algorithm {

    /**
     * 斐波那契数列
     * @param n
     * @return
     * @throws Exception
     */
    public static int feb(int n) throws Exception {
        if (n<1) {
            throw new Exception("非法输入");
        }
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return feb(n-1) + feb(n-2);
        }

    }

}
