package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 12/19/25 16:14
 */
public class LeetCode3577 {

    public int countPermutations(int[] complexity) {
        int mod = 1_000_000_007;
        int n = complexity.length;
        int[] dp = new int[n];
        int[] minIndex = new int[n];
        minIndex[0] = 0;
        for (int i = 1; i < n; i++) {
            if (complexity[i] < complexity[minIndex[i - 1]]) {
                minIndex[i] = i;
            } else {
                minIndex[i] = minIndex[i - 1];
            }
            if (complexity[minIndex[i - 1]] < complexity[i]) {
                dp[i] = i - minIndex[i];
            }
        }
        long res = 1;
        for (int i = 1; i < dp.length; i++) {
            res = (dp[i] * res) % mod;
        }
        return (int) res;
    }

    public int countPermutations__(int[] complexity) {
        int mod = 1_000_000_007;
        int n = complexity.length;
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0])
                return 0;
        }
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            int index = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (complexity[j] < complexity[i]) {
                    index = j;
                }
            }
            dp[i] = i - index;
        }
        System.out.println(Arrays.toString(dp));
        long res = 1;
        for (int i = 1; i < dp.length; i++) {
            res = (dp[i] * res) % mod;
        }
        return (int) res;
    }

}

