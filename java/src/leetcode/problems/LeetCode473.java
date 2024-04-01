package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/1 23:53
 */
public class LeetCode473 {

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return backtrack(matchsticks, 0, new int[4], sum / 4);
    }

    private boolean backtrack(int[] nums, int index, int[] edges, int target) {
        if (index == nums.length) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] + nums[index] > target) {
                continue;
            }
            if ((i > 0 && edges[i] == edges[i - 1])) {
                continue;
            }
            edges[i] += nums[index];
            if (backtrack(nums, index + 1, edges, target)) {
                return true;
            }
            edges[i] -= nums[index];
        }
        return false;
    }

    public void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }
}
