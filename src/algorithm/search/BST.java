package algorithm.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zhouwei
 * @Description: 二分搜索树(每个节点的键值大于左孩子，小于右孩子，以左右孩子为根的子树仍为二分搜索树)
 * @Date: 2019/7/22 15:37
 * @Version: 1.0
 **/
public class BST<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }

        public Node(Node node){
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    private Node root;  // 根节点
    private int count;  // 树种的节点个数

    public BST() {
        root = null;
        count = 0;
    }

    // 返回二分搜索树的节点个数
    public int size() {
        return count;
    }

    // 返回二分搜索树是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    // 向以node为根的二分搜索树中, 插入节点(key, value), 使用递归算法
    // 返回插入新节点后的二分搜索树的根
    private Node insert(Node node, Key key, Value value){

        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (node.key.compareTo(key) == 0) {
            node.value = value;
        } else if (node.key.compareTo(key) > 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;
    }
    //TODO:非递归实现节点插入

    private Node search(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) == 0) {
            return node;
        } else if (node.key.compareTo(key) > 0) {
            node = search(node.left, key);
        } else {
            node = search(node.right, key);
        }
        return node;
    }

    private boolean contain(Node node, Key key) {
        if (node == null) {
            return false;
        }
        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) > 0) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }
    }

    /**
     * 先序遍历(深度优先遍历)
     * @param node
     */
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历(深度优先遍历)
     * @param node
     */
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历(深度优先遍历)
     * @param node
     */
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }

    /**
     * 层序遍历(广度优先遍历)
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.key + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 找到最小的Key
     * @return
     */
    public Key findMin() {
        return findMin(root).key;
    }

    private Node findMin(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 找到最大的Key
     * @return
     */
    public Key findMax() {
        return findMax(root).key;
    }

    private Node findMax(Node node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点,返回删除节点后新的二分搜索树的根
     * @return
     */
    public void removeMin() {
        if (root != null) {
            removeMin(root);
        }
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            count --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点,返回删除节点后新的二分搜索树的根
     * @return
     */
    public void removeMax() {
        if (root != null) {
            removeMax(root);
        }
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            count --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 根据Key删除节点
     * @param key
     */
    public void remove(Key key) {
        root = remove(root, key);
    }

    private Node remove(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else {
            //左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                count--;
                return rightNode;
            }
            //右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                count--;
                return leftNode;
            }
            //左、右子树都不为空的情况
            Node successor = new Node(findMin(node.right));
            count ++;
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            count --;
            return successor;
        }
    }



    public static void main(String[] args) {
        int N = 10;
        BST<Integer,String> bst = new BST<>();

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++) {
            arr[i] = new Integer(i);
        }

        // 打乱数组顺序
        for(int i = 0 ; i < N ; i ++){
            int pos = (int) (Math.random() * (i+1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
        //构造BST
        for(int i = 0 ; i < N ; i ++) {
            bst.insert(new Integer(arr[i]), String.valueOf(arr[i]));
        }

        System.out.print("先序遍历：");
        bst.preOrder(bst.root);
        System.out.println();
        System.out.print("中序遍历：");
        bst.inOrder(bst.root);
        System.out.println();
        System.out.print("后序遍历：");
        bst.postOrder(bst.root);
        System.out.println();
        System.out.print("层序遍历：");
        bst.levelOrder();
        System.out.println();
        System.out.println("最小Key: " + bst.findMin());
        System.out.println("最大Key: " + bst.findMax());

        bst.removeMin();
        bst.removeMax();
        System.out.println("移除最大最小节点后：");
        System.out.println("最小Key: " + bst.findMin());
        System.out.println("最大Key: " + bst.findMax());

        bst.remove(5);

    }

}
