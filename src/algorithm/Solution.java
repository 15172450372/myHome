package algorithm;


/**
 * @Author: zhouwei
 * @Description: 根据前序, 后序还原树
 * @Date: 2019/12/25 上午12:16
 * @Version: 1.0
 **/
public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        //node1.right = node3;
        //node2.left = node4;
        //node2.right = node5;
        //node3.left = node6;
        //node3.right = node7;


        System.out.println("...");
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode ans = null;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        recurseTree(root,p,q);
        return ans;
    }

    private static boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        int left = recurseTree(root.left,p,q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        int right = recurseTree(root.right,p,q) ? 1 : 0;

        int sum = left + mid + right;

        if (sum >= 2) {
            ans = root;
        }

        return sum > 0;
    }



}
