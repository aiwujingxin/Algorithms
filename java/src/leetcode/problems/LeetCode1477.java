package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/20 20:32
 * @see LeetCode1031
 */
public class LeetCode1477 {

    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        int sum = 0;
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int bestSoFar = Integer.MAX_VALUE;
        int right = 0;
        while (right < n) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, best[left - 1] + right - left + 1);
                }
                bestSoFar = Math.min(bestSoFar, right - left + 1);
            }
            best[right] = bestSoFar;
            right++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
