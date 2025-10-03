package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 11:20
 * @description 一题多解
 */
public class LeetCode2571 {

    public int minOperations(int n) {
        if (n == 1 || n == 2)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int c = cal(i);
            dp[i] = Math.min(dp[i - (1 << (c - 1))], dp[(1 << c) - i]) + 1;
        }
        return dp[n];
    }

    public int cal(int n) {
        int c = 0;
        while ((1 << c) < n) {
            c++;
        }
        return c;
    }
}
