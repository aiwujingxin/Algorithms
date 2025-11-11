package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 11/10/25 14:36
 * 题目中的 `0 <= i < j < nums.length` 这个条件，其根本目的是防止重复计数和避免一个元素与自身配对。
 */
public class LeetCode2563 {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int left = findL(nums, i + 1, n - 1, lower - nums[i]);
            int right = findR(nums, i + 1, n - 1, upper - nums[i]);
            if (left == -1 || right == -1) continue;
            ans += Math.max(0, right - left + 1);
        }
        return ans;
    }

    int findL(int[] a, int l, int r, int x) {
        while (l < r) {
            int mid = l + r >> 1;
            if (a[mid] < x)
                l = mid + 1;
            else
                r = mid;
        }
        if (a[l] < x)
            return -1;
        return l;
    }

    int findR(int[] a, int l, int r, int x) {
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (a[mid] > x)
                r = mid - 1;
            else
                l = mid;
        }
        if (a[l] > x)
            return -1;
        return l;
    }
}
