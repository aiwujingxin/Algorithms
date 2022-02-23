package codeTop.ms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-02-16 7:40 PM
 */
public class LeetCode22 {

    public List<String> generateParenthesis(int n) {

        if (n == 0) {
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();
        helper(list, n, 0, 0, new StringBuilder());
        return list;

    }

    private void helper(List<String> list, int left, int right, int n, StringBuilder sb) {
        if (right == n) {
            list.add(sb.toString());
        }
        if (left < n) {
            sb.append("(");
            helper(list, left + 1, right, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            helper(list, left, right + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
