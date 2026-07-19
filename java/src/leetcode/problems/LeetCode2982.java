package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 6/25/26 14:24
 */
public class LeetCode2982 {

    public int maximumLength(String s) {
        int n = s.length();
        int ans = -1;
        // counts[字母][长度]
        int[][] counts = new int[26][n + 1];
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int len = j - i;
            int idx = s.charAt(i) - 'a';
            // 只考虑 len, len-1, len-2
            for (int k = len; k >= Math.max(1, len - 2); k--) {
                counts[idx][k] += len - k + 1;
                if (counts[idx][k] >= 3) {
                    ans = Math.max(ans, k);
                }
            }
            if (ans == n) return ans;
            i = j;
        }
        return ans;
    }
}
