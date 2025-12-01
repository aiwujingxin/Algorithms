package leetcode.problems;


import knowledge.datastructure.string.hash.DStringHash;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 12/1/25 15:47
 */
public class LeetCode1638 {

    public int countSubstrings(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dpl = new int[m + 1][n + 1];
        int[][] dpr = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dpl[i + 1][j + 1] = s.charAt(i) == t.charAt(j) ? (dpl[i][j] + 1) : 0;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dpr[i][j] = s.charAt(i) == t.charAt(j) ? (dpr[i + 1][j + 1] + 1) : 0;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    ans += (dpl[i][j] + 1) * (dpr[i + 1][j + 1] + 1);
                }
            }
        }
        return ans;
    }


    class Solution_IntervalDP {

        public int countSubstrings(String s, String t) {
            int n = s.length();
            int m = t.length();
            int ans = 0;
            // dp[i][j][len] 表示 s[i..i+len-1] 与 t[j..j+len-1] 的不同字符数
            // 注意：这里 len >= 1
            int[][][] dp = new int[n][m][Math.min(n, m) + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j][1] = s.charAt(i) == t.charAt(j) ? 0 : 1;
                    if (dp[i][j][1] == 1) ans++;
                }
            }
            // 枚举长度 len >= 2
            for (int len = 2; len <= Math.min(n, m); len++) {
                for (int i = 0; i + len - 1 < n; i++) {
                    for (int j = 0; j + len - 1 < m; j++) {
                        dp[i][j][len] = dp[i][j][len - 1] + (s.charAt(i + len - 1) == t.charAt(j + len - 1) ? 0 : 1);
                        if (dp[i][j][len] == 1) {
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }

    }

    class Solution_String_hash {

        public int countSubstrings(String s, String t) {
            int n = s.length();
            int m = t.length();
            DStringHash tHash = new DStringHash(t);
            HashMap<Long, Integer> map = new HashMap<>();
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < m; i++) {
                set.add(t.charAt(i));
                for (int j = i + 1; j <= m; j++) {
                    long[] h = tHash.getHash(i, j);
                    long key = (h[0] << 32) | h[1]; // 合并为单个 long 作为 key
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
            int cnt = 0;
            DStringHash sHash = new DStringHash(s);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    int len = j - i;
                    for (int k = 0; k < len; k++) {
                        char originalChar = s.charAt(i + k);
                        for (char newChar : set) {
                            if (newChar != originalChar) {
                                long[] newKey = sHash.getUpdatedHash(i, j, k, newChar);
                                long key = (newKey[0] << 32) | newKey[1];
                                cnt += map.getOrDefault(key, 0);
                            }
                        }
                    }
                }
            }
            return cnt;
        }
    }

}

