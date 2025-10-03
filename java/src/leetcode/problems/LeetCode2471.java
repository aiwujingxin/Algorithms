package leetcode.problems;

import common.TreeNode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/2 18:27
 */
public class LeetCode2471 {

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                arr[i] = node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res += minimumOperations(arr);
        }
        return res;
    }


    public int minimumOperations(int[] nums) {
        int cnt = 0, n = nums.length;
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);
        // Map<num, idx>  记录值正确的索引下标
        Map<Integer, Integer> rightIdxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            rightIdxMap.put(sorted[i], i);
        }
        for (int i = 0; i < n; i++) {
            while (rightIdxMap.get(nums[i]) != i) {
                swap(nums, i, rightIdxMap.get(nums[i]));
                cnt++;
            }
        }
        return cnt;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
