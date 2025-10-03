package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 15:54
 */
public class LeetCode22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(0, 0, n, res, new StringBuilder());
        return res;
    }

    private void backtrack(int l, int r, int n, List<String> res, StringBuilder sb) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }
        if (l < n) {
            sb.append("(");
            backtrack(l + 1, r, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < l) {
            sb.append(")");
            backtrack(l, r + 1, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
