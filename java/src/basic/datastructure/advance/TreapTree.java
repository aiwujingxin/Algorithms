package basic.datastructure.advance;

import leetcode.*;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/23 11:47
 * @see LeetCode480
 */

public class TreapTree {

    final int range = 10000010;
    final int INF = 0x3f3f3f3f;
    private Node root = null;

    int rand() {
        return new Random().nextInt(2 * range);
    }

    public void build() {
        root = new Node(-INF, rand());
        root.right = new Node(INF, rand());
        pushup(root);
        if (root.val < root.right.val)
            root = zag(root);
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public void remove(int key) {
        root = remove(root, key);
    }

    public int getKeyByRang(int range) {
        return getKeyByRang(root, range);
    }

    public int getRangByKey(int key) {
        return getRangByKey(root, key);
    }

    public int getPre(int key) {
        return getPre(root, key);
    }

    public int getNext(int key) {
        return getNext(root, key);
    }

    public Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key, rand());
        }
        if (node.key == key) {
            node.cnt++;
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
            if (node.left.val > node.val) {
                node = zig(node);
            }
        } else if (key > node.key) {
            node.right = insert(node.right, key);
            if (node.right.val > node.val) {
                node = zag(node);
            }
        }
        pushup(node);
        return node;
    }

    public Node remove(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = remove(node.left, key);
            pushup(node);
            return node;
        }

        if (key > node.key) {
            node.right = remove(node.right, key);
            pushup(node);
            return node;
        }

        // 相等的时候
        if (node.cnt > 1) {
            node.cnt--;
            pushup(node);
            return node;
        }
        if (node.left == null && node.right == null) {
            return null;
        } else {
            if (node.left == null) {// 左旋
                node = zag(node);
                node.left = remove(node.left, key);
                pushup(node);
                return node;
            }
            if (node.right == null) {// 右旋
                node = zig(node);
                node.right = remove(node.right, key);
                pushup(node);
                return node;
            }
            if (node.left.key > node.right.key) {// 左孩子上来， 右旋
                node = zig(node);
                node.right = remove(node.right, key);
            } else {// 右孩子上来， 左旋
                node = zag(node);
                node.left = remove(node.left, key);
            }
        }

        pushup(node);
        return node;
    }

    public int getKeyByRang(Node node, int range) {
        if (node == null) {
            return INF;
        }
        Node left = node.left;
        int lsize = left == null ? 0 : left.size;
        if (lsize >= range) {
            return getKeyByRang(node.left, range);
        }
        if (lsize + node.cnt >= range) {
            return node.key;
        }
        return getKeyByRang(node.right, range - lsize - node.cnt);

    }

    public int getRangByKey(Node node, int key) {
        if (node == null)
            return 0;
        Node left = node.left;
        int lsize = left == null ? 0 : left.size;

        if (key > node.key) {
            return lsize + node.cnt + getRangByKey(node.right, key);
        }

        if (key == node.key) {

            return lsize + 1;
        }

        return getRangByKey(node.left, key);
    }

    public int getPre(Node node, int key) {
        if (node == null) {

            return -INF;
        }
        if (key <= node.key) {

            return getPre(node.left, key);
        }
        return Math.max(node.key, getPre(node.right, key));
    }

    public int getNext(Node node, int key) {
        if (node == null) {
            return INF;
        }

        if (key >= node.key) {
            return getNext(node.right, key);
        }

        return Math.min(node.key, getNext(node.left, key));
    }

    Node zig(Node node) {// 右旋, 返回此时的该位置节点
        Node p = node.left;
        node.left = p.right;
        p.right = node;
        pushup(p.right);
        pushup(p);
        return p;
    }

    Node zag(Node node) {// 左旋
        Node p = node.right;
        node.right = p.left;
        p.left = node;
        pushup(p.left);
        pushup(p);
        return p;
    }

    void pushup(Node node) {

        int lsize, rsize;
        lsize = rsize = 0;
        if (node.left != null) {
            lsize = node.left.size;
        }

        if (node.right != null) {
            rsize = node.right.size;
        }
        node.size = node.cnt + lsize + rsize;

    }

    // 打印Treap树中的节点（中序遍历）
    public void printTree() {
        inorderTraversal(root);
    }

    public void postprintTree() {
        postorder(root);
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

    static class Node {
        int key, val, cnt, size;
        Node left, right;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.cnt = this.size = 1;
        }
    }
}
