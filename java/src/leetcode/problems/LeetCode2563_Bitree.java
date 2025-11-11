package leetcode.problems;

import knowledge.datastructure.adv.BITree;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 11/10/25 15:19
 */
public class LeetCode2563_Bitree {

    public long countFairPairs(int[] nums, int lower, int upper) {
        // 离散化
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // 构建映射
        List<Integer> sorted = new ArrayList<>(set);
        Map<Integer, Integer> numToIdx = new HashMap<>();
        for (int i = 0; i < sorted.size(); i++) {
            numToIdx.put(sorted.get(i), i);
        }
        int n = sorted.size();
        BITree tree = new BITree(n);
        long ans = 0;
        for (int num : nums) {
            int leftTarget = lower - num;
            int rightTarget = upper - num;
            // 在离散化数组中找到范围
            int leftIdx = findLowerBound(sorted, leftTarget);
            int rightIdx = findUpperBound(sorted, rightTarget);
            if (leftIdx <= rightIdx) {
                ans += tree.sum(rightIdx + 1) - tree.sum(leftIdx);
            }
            // 更新当前数字
            tree.add(numToIdx.get(num) + 1, 1); // 树状数组从1开始
        }
        return ans;
    }

    private int findLowerBound(List<Integer> sorted, int target) {
        int left = 0, right = sorted.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sorted.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int findUpperBound(List<Integer> sorted, int target) {
        int left = 0, right = sorted.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sorted.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
