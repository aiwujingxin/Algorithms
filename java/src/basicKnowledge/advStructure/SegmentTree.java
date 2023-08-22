package basicKnowledge.advStructure;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/19 00:37
 * @link <a href="https://www.youtube.com/watch?v=e_bK-dgPvfM">讲解</a>
 */
public class SegmentTree {

    private final int[] segmentTree;
    private final int[] nums;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        this.segmentTree = new int[nums.length * 4];
        buildTree(nums, 0, 0, nums.length - 1);
    }

    // 后序遍历
    public void buildTree(int[] nums, int node, int start, int end) {
        // 叶子节点
        if (start == end) {
            segmentTree[node] = nums[start];
            return;
        }
        int mid = (start + end) / 2;
        int left_node = 2 * node + 1;
        int right_node = 2 * node + 2;
        buildTree(nums, left_node, start, mid);
        buildTree(nums, right_node, mid + 1, end);
        segmentTree[node] = segmentTree[left_node] + segmentTree[right_node];
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
}
