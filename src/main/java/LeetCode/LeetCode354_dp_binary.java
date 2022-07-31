package LeetCode;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/25 22:16
 */
public class LeetCode354_dp_binary {

    public static void main(String[] args) {
        System.out.println(new LeetCode354_dp_binary().maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }

    //https://leetcode.com/problems/russian-doll-envelopes/discuss/1734526/Java-LIS-Revisited-or-Binary-Search-Best-Explanation
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        //dp[i] 代表着表示h的前 i 个元素可以组成的长度为 j 的最长严格递增子序列的末尾元素的最小值
        int[] dp = new int[envelopes.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);//赋值，赋一个无意义的值

        dp[0] = Integer.MIN_VALUE;
        int ans = 0;
        for (int[] envelope : envelopes) {
            int val = envelope[1];
            int insertIndex = binarySearch(dp, val);
            ans = Math.max(ans, insertIndex);
            if (dp[insertIndex] >= val) {
                dp[insertIndex] = val;
            }
        }
        return ans;
    }

    public int binarySearch(int[] dp, int val) {
        int lo = 0, hi = dp.length - 1, res = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (dp[mid] < val) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res + 1;
    }
}
