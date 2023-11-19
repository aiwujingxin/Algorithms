package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/2/15 22:00
 * @description 构造DP结果
 */
public class LeetCode368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            int t = 1, pre = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > t) {
                        t = dp[j] + 1;
                        pre = j;
                    }
                }
            }
            dp[i] = t;
            g[i] = pre;
        }

        int max = -1, idx = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                idx = i;
                max = dp[i];
            }
        }
        // build res
        List<Integer> ans = new ArrayList<>();
        while (ans.size() != max) {
            ans.add(nums[idx]);
            idx = g[idx];
        }
        return ans;
    }
}
