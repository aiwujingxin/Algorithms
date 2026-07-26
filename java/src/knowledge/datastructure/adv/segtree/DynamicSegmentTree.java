package knowledge.datastructure.adv.segtree;

/**
 * 动态开点线段树 (Dynamic Segment Tree)。
 * 适用于值域很大（如 1 到 10^9），但实际操作节点数较少的情况。
 * 支持单点更新和区间求和（可根据需要修改为其他操作）。
 */
public class DynamicSegmentTree {

    private static class Node {
        long val;
        Node left, right;
    }

    private final Node root;
    private final long minVal;
    private final long maxVal;

    public DynamicSegmentTree(long minVal, long maxVal) {
        this.root = new Node();
        this.minVal = minVal;
        this.maxVal = maxVal;
    }

    /**
     * 单点更新：将位置 idx 的值加上 val
     */
    public void add(long idx, long val) {
        add(root, minVal, maxVal, idx, val);
    }

    private void add(Node node, long start, long end, long idx, long val) {
        if (start == end) {
            node.val += val;
            return;
        }
        long mid = start + (end - start) / 2;
        if (idx <= mid) {
            if (node.left == null) node.left = new Node();
            add(node.left, start, mid, idx, val);
        } else {
            if (node.right == null) node.right = new Node();
            add(node.right, mid + 1, end, idx, val);
        }
        node.val = (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0);
    }

    /**
     * 查询区间 [L, R] 的和
     */
    public long query(long L, long R) {
        return query(root, minVal, maxVal, L, R);
    }

    private long query(Node node, long start, long end, long L, long R) {
        if (node == null || L > end || R < start) return 0;
        if (L <= start && R >= end) return node.val;

        long mid = start + (end - start) / 2;
        long sum = 0;
        if (L <= mid) sum += query(node.left, start, mid, L, R);
        if (R > mid) sum += query(node.right, mid + 1, end, L, R);
        return sum;
    }
}