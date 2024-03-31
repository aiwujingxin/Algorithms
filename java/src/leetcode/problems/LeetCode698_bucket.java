package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/9 21:49
 * @description 球盒模型 <a href="https://labuladong.online/algo/practice-in-action/two-views-of-backtrack/">...</a>
 */
public class LeetCode698_bucket {

    HashMap<Integer, Boolean> memo = new HashMap<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int v : nums) {
            sum += v;
        }
        if (sum % k != 0) {
            return false;
        }
        int used = 0;
        int target = sum / k;
        return backtrack(k, 0, nums, 0, used, target);
    }

    boolean backtrack(int k, int sum, int[] nums, int start, int used, int target) {
        if (k == 0) {
            return true;
        }
        if (sum == target) {
            boolean res = backtrack(k - 1, 0, nums, 0, used, target);
            memo.put(used, res);
        }
        if (memo.containsKey(used)) {
            return memo.get(used);
        }
        for (int i = start; i < nums.length; i++) {
            if (((used >> i) & 1) == 1) {
                continue;
            }
            if (nums[i] + sum > target) {
                continue;
            }
            used |= 1 << i;
            if (backtrack(k, sum + nums[i], nums, i + 1, used, target)) {
                return true;
            }
            used ^= 1 << i;
        }
        return false;
    }
}
