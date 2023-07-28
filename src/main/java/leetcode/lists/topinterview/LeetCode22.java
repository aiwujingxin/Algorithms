package leetcode.lists.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/21 01:05
 */

public class LeetCode22 {

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        dfs(0, 0, n, list, new StringBuilder());
        return list;
    }

    private void dfs(int left, int right, int n, List<String> list, StringBuilder sb) {

        if (sb.length() == n * 2) {
            list.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append("(");
            dfs(left + 1, right, n, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append(")");
            dfs(left, right + 1, n, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}


