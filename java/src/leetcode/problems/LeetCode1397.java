package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/9 22:23
 */
public class LeetCode1397 {

    int n;
    int[][] memo;
    int[] next;
    int MOD = (int) 1e9 + 7;

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        this.n = n;
        int len = evil.length();
        memo = new int[n][len];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        next = makePrefix(evil);
        return dfs(s1, s2, evil, 0, 0, true, true);
    }

    public int dfs(String s1, String s2, String evil, int i, int j, boolean downLimited, boolean upLimited) {
        // 代表字符串中出现了 evil
        if (j == evil.length()) return 0;
        if (i == n) return 1;
        if (!downLimited && !upLimited && memo[i][j] != -1) return memo[i][j];

        long ans = 0;
        char down = downLimited ? s1.charAt(i) : 'a', up = upLimited ? s2.charAt(i) : 'z';
        for (char k = down; k <= up; k++) {
            int nj = j;
            while (nj > 0 && k != evil.charAt(nj)) nj = next[nj - 1];
            // 此处要注意，当 nj == 0 的时候，会存在 k != evil.charAt(nj) 的情况
            // 若直接 nj + 1 进入递归，是认为此时的两个字符一定是匹配上了，实际上可能并没有
            if (nj == 0 && k != evil.charAt(nj)) nj = -1;
            ans = (ans + dfs(s1, s2, evil, i + 1, nj + 1, downLimited && k == down, upLimited && k == up)) % MOD;
        }
        if (!downLimited && !upLimited) memo[i][j] = (int) ans;
        return (int) ans;
    }

    public int[] makePrefix(String needle) {
        int[] prefix = new int[needle.length()];
        int i = 0, j = 1;
        while (j < needle.length()) {
            if (needle.charAt(i) == needle.charAt(j)) {
                prefix[j] = i + 1;
                i++;
                j++;
            } else {
                if (i - 1 >= 0) {
                    i = prefix[i - 1];
                } else {
                    prefix[j++] = 0;
                }
            }
        }
        return prefix;
    }
}
