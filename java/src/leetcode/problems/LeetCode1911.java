package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 7/20/26 20:39
 */
public class LeetCode1911 {

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        // even[i]: 考虑前i个数，当前子序列长度为偶数（下一次要加）的最大和
        // odd[i]:  考虑前i个数，当前子序列长度为奇数（下一次要减）的最大和
        long[] even = new long[n];
        long[] odd = new long[n];
        even[0] = 0;
        odd[0] = nums[0];
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            even[i] = even[i - 1];
            odd[i] = odd[i - 1];
            even[i] = Math.max(even[i], odd[i - 1] + num);
            odd[i] = Math.max(odd[i], even[i - 1] - num);
        }
        System.out.println(Arrays.toString(odd));
        System.out.println(Arrays.toString(even));
        return Math.max(even[n - 1], odd[n - 1]);
    }
}
