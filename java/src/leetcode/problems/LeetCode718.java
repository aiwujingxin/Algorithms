package leetcode.problems;

import knowledge.mathematics.impl.MathUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jingxinwu
 * @date 2021-12-26 10:00 PM
 */
public class LeetCode718 {

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    int mod = 1_000_000_007;
    int base = 113;

    public int findLength_RabinKarp(int[] A, int[] B) {
        int l = 1, r = Math.min(A.length, B.length) + 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(A, B, mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l - 1;
    }

    public boolean check(int[] A, int[] B, int len) {
        long hashA = 0;
        for (int i = 0; i < len; i++) {
            hashA = (hashA * base + A[i]) % mod;
        }
        Set<Long> set = new HashSet<>();
        set.add(hashA);
        long mul = MathUtil.modPow(base, len - 1, 1);
        for (int i = len; i < A.length; i++) {
            hashA = ((hashA - A[i - len] * mul % mod + mod) % mod * base + A[i]) % mod;
            set.add(hashA);
        }
        long hashB = 0;
        for (int i = 0; i < len; i++) {
            hashB = (hashB * base + B[i]) % mod;
        }
        if (set.contains(hashB)) {
            return true;
        }
        for (int i = len; i < B.length; i++) {
            hashB = ((hashB - B[i - len] * mul % mod + mod) % mod * base + B[i]) % mod;
            if (set.contains(hashB)) {
                return true;
            }
        }
        return false;
    }
}
