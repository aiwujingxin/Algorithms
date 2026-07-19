package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 6/25/26 14:18
 */
public class LeetCode3737 {

    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long[] presum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + (nums[i - 1] == target ? 1 : 0);
        }
        System.out.println(Arrays.toString(presum));
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                long sum = presum[j] - presum[i];
                if (sum * 2 > (j - i + 1)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
