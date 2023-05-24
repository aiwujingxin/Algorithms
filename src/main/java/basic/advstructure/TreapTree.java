package basic.advstructure;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/23 11:47
 * from gpt
 */

public class TreapTree {
    private Node root;

    // 构造函数
    public TreapTree() {
        root = null;
    }

    // 中序遍历Treap树
    private void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.key + " ");
            inorderTraversal(root.right);
        }
    }

    private void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }

    // 在Treap树中插入节点
    public void insert(int key) {
        root = insertNode(root, key);
    }

    // 在Treap树中删除节点
    public void delete(int key) {
        root = deleteNode(root, key);
    }

    // 打印Treap树中的节点（中序遍历）
    public void printTree() {
        inorderTraversal(root);
    }

    public void postprintTree() {
        postorder(root);
    }

    // 在Treap树中插入节点
    private Node insertNode(Node root, int key) {
        // 执行标准BST插入
        if (root == null) {
            return new Node(key);
        }

        if (key < root.key) {
            root.left = insertNode(root.left, key);
            // 通过旋转保持堆的性质
            if (root.left.priority > root.priority) {
                root = rightRotate(root);
            }
        } else if (key > root.key) {
            root.right = insertNode(root.right, key);
            // 通过旋转保持堆的性质
            if (root.right.priority > root.priority) {
                root = leftRotate(root);
            }
        }

        return root;
    }

    // 在Treap树中删除节点
    private Node deleteNode(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {
            // 找到要删除的节点
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                // 如果左右子节点都存在，根据优先级进行旋转
                if (root.left.priority < root.right.priority) {
                    root = leftRotate(root);
                    root.left = deleteNode(root.left, key);
                } else {
                    root = rightRotate(root);
                    root.right = deleteNode(root.right, key);
                }
            }
        }

        return root;
    }


    // 左旋操作
    private Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    // 右旋操作
    private Node rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }


    static class Node {
        int key; // 节点的键值
        int priority; // 节点的优先级
        Node left; // 左子节点的引用
        Node right; // 右子节点的引用

        public Node(int key) {
            this.key = key;
            this.priority = new Random().nextInt(100); // 生成随机优先级
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        TreapTree treap = new TreapTree();

        treap.insert(50);
        treap.insert(30);
        treap.insert(20);
        treap.insert(40);
        treap.insert(70);
        treap.insert(60);
        treap.insert(80);

        System.out.println("Treap树中的节点（中序遍历）：");
        treap.printTree();
        System.out.println();

        treap.delete(20);
        treap.delete(40);

        System.out.println("删除节点后的Treap树（中序遍历）：");
        treap.printTree();
        System.out.println();
    }
}
