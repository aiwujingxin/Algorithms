package basicKnowledge.datastructure.tree.segmenttree;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/19 00:37
 */
public class SegTree {

    //https://www.youtube.com/watch?v=e_bK-dgPvfM

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 11};
        int[] tree = new int[1000];

        new SegTree().buildTree(arr, tree, 0, 0, arr.length - 1);
        System.out.println(Arrays.toString(tree));
    }


    private void buildTree(int[] arr, int[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        int left_node = 2 * node + 1;
        int right_node = 2 * node + 2;
        buildTree(arr, tree, left_node, start, mid);
        buildTree(arr, tree, right_node, mid + 1, end);
        tree[node] = tree[left_node] + tree[right_node];
    }


    void update(int[] arr, int[] tree, int node, int start, int end, int idx, int val) {
        if (start == end) {
            arr[idx] = val;
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        int leftNode = 2 * node + 1;
        int rightNode = 2 * node + 2;
        if (idx >= start && idx <= mid) {
            update(arr, tree, leftNode, start, mid, idx, val);
        } else {
            update(arr, tree, rightNode, mid + 1, end, idx, val);
        }
        tree[node] = tree[leftNode] + tree[rightNode];
    }

    private int queryTree(int[] arr, int[] tree, int node, int start, int end, int L, int R) {
        if (R > start || L > end) {
            return 0;
        } else if (L <= start && end <= R) {
            return tree[node];
        } else if (start == end) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftNode = 2 * node + 1;
        int rightNode = 2 * node + 2;
        int sum_left = queryTree(arr, tree, leftNode, start, mid, L, R);
        int sum_right = queryTree(arr, tree, rightNode, mid + 1, end, L, R);
        return sum_left + sum_right;
    }
}
