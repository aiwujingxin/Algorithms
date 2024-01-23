package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/26 20:44
 * @see LeetCode300_bs
 */
public class LeetCode1713 {

    public int minOperations(int[] target, int[] arr) {
        int n = target.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(target[i], i);
        }

        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            if (map.containsKey(j)) {
                list.add(map.get(j));
            }
        }
        return n - lengthOfLIS(list);
    }

    public int lengthOfLIS(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return 0;
        }
        int n = nums.size();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        int res = 0;
        for (int num : nums) {
            int insertIndex = leftBound(dp, num);
            if (dp[insertIndex] >= num) {
                dp[insertIndex] = num;
            }
            res = Math.max(res, insertIndex);
        }
        return res;
    }

    public int leftBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] < target) {
            return left + 1;
        }
        return left;
    }
}
