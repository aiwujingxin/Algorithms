package knowledge.datastructure.adv.segtree;

/**
 * Persistent Segment Tree (主席树)
 * Typically used for querying the K-th smallest element in a range [L, R].
 * Time complexity: O(N log M) for build, O(log M) per query, where M is the value range.
 */
public class PersistentSegmentTree {
    private static class Node {
        int count;
        Node left, right;

        Node(int count) {
            this.count = count;
        }
    }

    private Node[] roots;
    private int minVal, maxVal;

    /**
     * Initializes the tree with the given array.
     *
     * @param arr    The input array
     * @param minVal The minimum possible value in the array
     * @param maxVal The maximum possible value in the array
     */
    public PersistentSegmentTree(int[] arr, int minVal, int maxVal) {
        this.minVal = minVal;
        this.maxVal = maxVal;
        roots = new Node[arr.length + 1];
        roots[0] = build(minVal, maxVal);

        for (int i = 0; i < arr.length; i++) {
            roots[i + 1] = insert(roots[i], minVal, maxVal, arr[i]);
        }
    }

    private Node build(int l, int r) {
        Node node = new Node(0);
        if (l == r) return node;
        int mid = l + (r - l) / 2;
        node.left = build(l, mid);
        node.right = build(mid + 1, r);
        return node;
    }

    private Node insert(Node prev, int l, int r, int val) {
        Node node = new Node(prev.count + 1);
        if (l == r) return node;

        int mid = l + (r - l) / 2;
        if (val <= mid) {
            node.left = insert(prev.left, l, mid, val);
            node.right = prev.right;
        } else {
            node.left = prev.left;
            node.right = insert(prev.right, mid + 1, r, val);
        }
        return node;
    }

    /**
     * Queries the K-th smallest element in the range [L, R].
     *
     * @param L The left index (1-based, inclusive)
     * @param R The right index (1-based, inclusive)
     * @param k The k-th position (1-based)
     * @return The K-th smallest value
     */
    public int queryKth(int L, int R, int k) {
        return query(roots[L - 1], roots[R], minVal, maxVal, k);
    }

    private int query(Node leftNode, Node rightNode, int l, int r, int k) {
        if (l == r) return l;

        int countInLeft = rightNode.left.count - leftNode.left.count;
        int mid = l + (r - l) / 2;

        if (countInLeft >= k) {
            return query(leftNode.left, rightNode.left, l, mid, k);
        } else {
            return query(leftNode.right, rightNode.right, mid + 1, r, k - countInLeft);
        }
    }
}
