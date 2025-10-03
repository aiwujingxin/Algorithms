package knowledge.datastructure.tree.bst;

import leetcode.problems.LeetCode327_treap;
import leetcode.problems.LeetCode480_treap;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/23 11:47
 * @description 平衡二叉搜索树 Treap树
 * @see LeetCode480_treap
 * @see LeetCode327_treap
 * Treap 是一种随机化的二叉搜索树，通过为每个节点分配一个随机的优先级，
 * 在维持二叉搜索树性质的同时，使得树结构在期望上保持平衡。
 * - BST 性质: 对于任意节点，其左子树所有节点的值 < 该节点的值 < 其右子树所有节点的值。
 * - Heap 性质: 对于任意节点，其优先级 > 其子节点的优先级 (这是一个最大堆)。
 */
public class TreapTree {
    private static final long INF = 0x3f3f3f3f3f3f3f3fL;
    private static final Random random = new Random();
    private Node root = null;

    private static class Node {
        long key;      // 节点的值 (BST性质)
        long priority; // 随机优先级 (Heap性质)
        long cnt;      // 相同键值的节点数量
        long size;     // 以该节点为根的子树的大小 (包括重复节点)
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

    public Node search(long key) {
        Node current = root;
        while (current != null) {
            if (key < current.key) {
                current = current.left;
            } else if (key > current.key) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public long getPre(long key) {
        return findPredecessor(key, false);
    }

    public long getPreOrEq(long key) {
        return findPredecessor(key, true);
    }

    public long getNext(long key) {
        return findSuccessor(key, false);
    }

    public long getNextOrEq(long key) {
        return findSuccessor(key, true);
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
    private long findPredecessor(long key, boolean allowEqual) {
        Node node = root;
        long result = Long.MIN_VALUE;
        while (node != null) {
            if (allowEqual ? (node.key <= key) : node.key < key) {
                result = node.key;
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return result;
    }

    private long findSuccessor(long key, boolean allowEqual) {
        Node node = root;
        long result = Long.MAX_VALUE;
        while (node != null) {
            if (allowEqual ? (node.key >= key) : (node.key > key)) {
                result = node.key;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return result;
    }

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
        node.size = node.cnt + getSize(node.left) + getSize(node.right);
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
