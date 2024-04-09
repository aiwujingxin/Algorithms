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

    private void backtrack(int left, int right, int n, List<String> res, StringBuilder sb) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            backtrack(left + 1, right, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            backtrack(left, right + 1, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
