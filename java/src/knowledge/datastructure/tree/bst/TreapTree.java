package knowledge.datastructure.tree.bst;

import leetcode.problems.*;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/23 11:47
 * @description 平衡二叉搜索树 Treap树
 * @see LeetCode480_treap
 * @see LeetCode327_treap
 */

public class TreapTree {

    private static final long INF = 0x3f3f3f3f3f3f3f3fL;
    private static final Random random = new Random();
    private Node root = null;

    private static class Node {
        long key, priority, cnt, size;
        Node left, right;

        Node(long key) {
            this.key = key;
            this.priority = random.nextLong();
            this.cnt = this.size = 1;
        }
    }

    public void insert(long key) {
        root = insert(root, key);
    }

    public void remove(long key) {
        root = remove(root, key);
    }

    public long lowerBound(long key) {
        Node node = root;
        long res = Long.MAX_VALUE;
        while (node != null) {
            if (node.key >= key) {
                res = node.key;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return res;
    }

    public long upperBound(long key) {
        Node node = root;
        long res = Long.MAX_VALUE;
        while (node != null) {
            if (node.key > key) {
                res = node.key;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return res;
    }

    public long getPre(long key) {
        Node node = root;
        long res = -INF;
        while (node != null) {
            if (node.key < key) {
                res = node.key;
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return res;
    }

    public long getNext(long key) {
        Node node = root;
        long res = INF;
        while (node != null) {
            if (node.key > key) {
                res = node.key;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return res;
    }

    public long getSize() {
        return getSize(root);
    }

    public long getKeyByRank(long rank) {
        return getKeyByRank(root, rank);
    }

    public long getRankByKey(long key) {
        return getRankByKey(root, key);
    }

    // ================= 内部方法 =================

    private Node insert(Node node, long key) {
        if (node == null) return new Node(key);
        if (key == node.key) {
            node.cnt++;
        } else if (key < node.key) {
            node.left = insert(node.left, key);
            if (node.left.priority > node.priority) node = rotate(node, false);
        } else {
            node.right = insert(node.right, key);
            if (node.right.priority > node.priority) node = rotate(node, true);
        }
        pushUp(node);
        return node;
    }

    private Node remove(Node node, long key) {
        if (node == null) return null;
        if (key < node.key) {
            node.left = remove(node.left, key);
        } else if (key > node.key) {
            node.right = remove(node.right, key);
        } else {
            if (node.cnt > 1) {
                node.cnt--;
            } else if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else if (node.left.priority > node.right.priority) {
                node = rotate(node, false);
                node.right = remove(node.right, key);
            } else {
                node = rotate(node, true);
                node.left = remove(node.left, key);
            }
        }
        if (node != null) pushUp(node);
        return node;
    }

    private Node rotate(Node node, boolean left) {
        Node p = left ? node.right : node.left;
        if (left) node.right = p.left;
        else node.left = p.right;
        if (left) p.left = node;
        else p.right = node;
        pushUp(node);
        pushUp(p);
        return p;
    }

    private void pushUp(Node node) {
        node.size = node.cnt +
                (node.left != null ? node.left.size : 0) +
                (node.right != null ? node.right.size : 0);
    }

    private long getSize(Node node) {
        return node == null ? 0 : node.size;
    }

    private long getKeyByRank(Node node, long rank) {
        if (node == null) return INF;
        long lsize = getSize(node.left);
        if (rank <= lsize) return getKeyByRank(node.left, rank);
        if (rank <= lsize + node.cnt) return node.key;
        return getKeyByRank(node.right, rank - lsize - node.cnt);
    }

    private long getRankByKey(Node node, long key) {
        if (node == null) return 0;
        if (key < node.key) return getRankByKey(node.left, key);
        long lsize = getSize(node.left);
        if (key == node.key) return lsize + 1;
        return lsize + node.cnt + getRankByKey(node.right, key);
    }
}
