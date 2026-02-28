package leetcode.problems;


/**
 * @author wujingxinit@outlook.com
 * @date 2/12/26 13:55
 */
public class LeetCode3713 {

    public int longestBalanced(String s) {
        int n = s.length();
        int[][] presum = new int[n + 1][26];
        presum[0][s.charAt(0) - 'a']++;
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1].clone();
            presum[i][s.charAt(i - 1) - 'a']++;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int pre = -1;
                boolean can = true;
                for (int k = 0; k < 26; k++) {
                    int c = presum[j + 1][k] - presum[i][k];
                    if (c == 0) continue;
                    if (pre != -1 && c != pre) {
                        can = false;
                        break;
                    }
                    pre = c;
                }
                if (can) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}
