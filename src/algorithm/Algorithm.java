package algorithm;

/**
 * @Descript:
 * @Author: zhouwei
 * @Date: 19-6-25 上午9:33
 * @Version 1.0
 */
public class Algorithm {

    public static void main(String[] args) {

    }

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

    /**
     * 链表反转
     * @param head 头节点
     * @return
     */
    private static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node p = head;
        Node q = head.next;
        head.next = null;
        Node r;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }

    static class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }



}
