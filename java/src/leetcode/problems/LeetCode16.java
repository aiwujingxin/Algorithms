package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/23 14:24
 */
public class LeetCode16 {

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int min = Math.abs(ans - target);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int t = Math.abs(sum - target);
                if (t == 0) return sum;
                if (t < min) {
                    min = t;
                    ans = nums[i] + nums[j] + nums[k];
                }
                if (sum < target) j++;
                else k--;
            }
        }
        return ans;
    }
}
