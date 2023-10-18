package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 17:42
 */
public class LeetCode22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, 0, 0, n, new StringBuilder());
        return res;
    }

    private void backtrack(List<String> res, int left, int right, int n, StringBuilder sb) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            backtrack(res, left + 1, right, n, sb);
            sb.deleteCharAt(sb.length() - 1);

        }
        if (right < left) {
            sb.append(")");
            backtrack(res, left, right + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
