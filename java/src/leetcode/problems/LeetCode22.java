package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

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

    class Solution {
        public int countParenthesis(int n) {
            long ans = 1; // C_0 = 1
            for (int i = 1; i <= n; i++) {
                // 利用卡特兰数递推公式：C_i = C_{i-1} * (4i - 2) / (i + 1)
                ans = ans * (4L * i - 2) / (i + 1);
            }
            return (int) ans;
        }
    }
}
