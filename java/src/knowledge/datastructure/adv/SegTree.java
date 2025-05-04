package knowledge.datastructure.adv;

import leetcode.problems.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/19 00:37
 * @description 线段树
 * range max/min 求区间最大最小值用segTree
 * @link <a href="https://www.youtube.com/watch?v=e_bK-dgPvfM">讲解</a>
 * @see LeetCode307_segtree
 * @see LeetCode315_segtree
 * @see LeetCode327_segtree
 * @see LeetCode218_segtree
 */
public class SegTree {

    private final int[] segmentTree;
    private final int[] numsTree;
    private final int[] nums;

    public SegTree(int[] nums) {
        this.nums = nums;
        this.segmentTree = new int[nums.length * 4];
        this.numsTree = new int[nums.length * 4];
        buildTree(nums, 0, 0, nums.length - 1);
    }

    // 后序遍历
    private void buildTree(int[] nums, int node, int start, int end) {
        // 叶子节点
        if (start == end) {
            segmentTree[node] = nums[start];
            numsTree[node] = nums[start];
            return;
        }
        int mid = (start + end) / 2;
        int leftNode = 2 * node + 1;
        int rightNode = 2 * node + 2;
        buildTree(nums, leftNode, start, mid);
        buildTree(nums, rightNode, mid + 1, end);
        segmentTree[node] = segmentTree[leftNode] + segmentTree[rightNode];
        numsTree[node] = Math.max(numsTree[leftNode], numsTree[rightNode]);
    }

    public void update(int idx, int val, int node, int start, int end) {
        if (start == end) {
            segmentTree[node] = val;
            nums[idx] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        int leftNode = 2 * node + 1;
        int rightNode = 2 * node + 2;
        // 向上更新路径
        if (idx <= mid) {
            update(idx, val, leftNode, start, mid);
        } else {
            update(idx, val, rightNode, mid + 1, end);
        }
        segmentTree[node] = segmentTree[leftNode] + segmentTree[rightNode];
        numsTree[node] = Math.max(numsTree[leftNode], numsTree[rightNode]);
    }

    public int queryTree(int left, int right, int node, int s, int e) {
        if (left == s && right == e) {
            return segmentTree[node];
        }
        int m = s + (e - s) / 2;
        if (right <= m) {
            return queryTree(left, right, node * 2 + 1, s, m);
        } else if (left > m) {
            return queryTree(left, right, node * 2 + 2, m + 1, e);
        } else {
            return queryTree(left, m, node * 2 + 1, s, m) + queryTree(m + 1, right, node * 2 + 2, m + 1, e);
        }
    }

    public double queryAverage(int left, int right) {
        int sum = queryTree(left, right, 0, 0, nums.length - 1);
        return sum / (double) (right - left + 1);
    }

    public int queryMax(int left, int right) {
        return queryMax(0, 0, nums.length - 1, left, right);
    }

    private int queryMax(int treeIndex, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MIN_VALUE;
        }
        if (left <= start && right >= end) {
            return numsTree[treeIndex];
        }
        int mid = start + (end - start) / 2;
        int maxLeft = queryMax(2 * treeIndex + 1, start, mid, left, right);
        int maxRight = queryMax(2 * treeIndex + 2, mid + 1, end, left, right);
        return Math.max(maxLeft, maxRight);
    }

    public int queryMin(int left, int right) {
        return queryMin(0, 0, nums.length - 1, left, right);
    }

    private int queryMin(int treeIndex, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && right >= end) {
            return numsTree[treeIndex];
        }
        int mid = start + (end - start) / 2;
        int minLeft = queryMin(2 * treeIndex + 1, start, mid, left, right);
        int minRight = queryMin(2 * treeIndex + 2, mid + 1, end, left, right);
        return Math.min(minLeft, minRight);
    }
}
