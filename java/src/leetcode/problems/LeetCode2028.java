package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/23 14:05
 */
public class LeetCode2028 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        int m = rolls.length;
        for (int roll : rolls) {
            sum += roll;
        }
        int nsum = mean * (m + n) - sum;
        if (nsum < 0) {
            return new int[]{};
        }
        if (nsum / n > 6 || nsum / n == 0 || (nsum / n == 6 && nsum % n != 0)) {
            return new int[]{};
        }
        int[] nums = new int[n];
        Arrays.fill(nums, nsum / n);
        if (nsum % n == 0) {
            return nums;
        }
        int yu = nsum % n;
        for (int i = 0; i < yu; i++) {
            nums[i]++;
        }
        return nums;
    }
}
