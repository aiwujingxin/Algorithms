package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/13 22:49
 */
public class LeetCode678_dfs_memo {
    private Boolean[][] dp;

    public boolean checkValidString(String s) {
        dp = new Boolean[s.length() + 1][s.length() + 1];
        return check(s, 0, 0);
    }

    private boolean check(String s, int start, int count) {
        if (count < 0) {
            return false;
        }

        if (start >= s.length()) {
            return count == 0;
        }

        if (dp[start][count] != null) {
            return dp[start][count];
        }
        char c = s.charAt(start);
        boolean res = false;
        if (c == '(') {
            res = check(s, start + 1, count + 1);
        } else if (c == ')') {
            if (count > 0) {
                res = check(s, start + 1, count - 1);
            }
        } else {
            res = (check(s, start + 1, count + 1) || check(s, start + 1, count - 1) || check(s, start + 1, count));
        }
        dp[start][count] = res;
        return res;
    }
}
