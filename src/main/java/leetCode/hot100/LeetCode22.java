package leetCode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/3 14:53
 */
public class LeetCode22 {

    public static void main(String[] args) {
        System.out.println(new LeetCode22().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {

        if (n == 0) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();

        backtrack(res, 0, 0, new StringBuilder(), n);

        return res;
    }

    private void backtrack(List<String> res, int left, int right, StringBuilder sb, int n) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append("(");
            backtrack(res, left + 1, right, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append(")");
            backtrack(res, left, right + 1, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}


