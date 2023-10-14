package leetcode.lists.lcr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 01:46
 */
public class LCR85 {

    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(0, 0, new StringBuilder(), n);
        return res;
    }

    private void backtrack(int left, int right, StringBuilder sb, int n) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            backtrack(left + 1, right, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append(")");
            backtrack(left, right + 1, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
