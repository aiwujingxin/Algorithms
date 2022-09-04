package leetCode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-16 10:46 下午
 */
public class LeetCode22 {

    public static void main(String[] args) {
        LeetCode22 leetCode22 = new LeetCode22();
        System.out.println(leetCode22.generateParenthesis(3));
    }


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        backtrack(res, 0, 0, n, new StringBuilder());
        return res;
    }

    private void backtrack(List<String> res, int open, int close, int n, StringBuilder sb) {

        if (close == n) {
            res.add(sb.toString());
        }
        if (open < n) {
            sb.append("(");
            backtrack(res, open + 1, close, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backtrack(res, open, close + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
