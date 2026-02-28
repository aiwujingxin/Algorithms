package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 15:33
 */
public class LeetCode224 {

    int i = 0;

    public int calculate(String s) {
        return dfs(s);
    }

    private int dfs(String s) {
        int res = 0, num = 0, sign = 1;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                num = dfs(s);       // 递归处理括号
            } else if (c == ')') {
                break;              // 结束当前层级
            } else if (c == '+' || c == '-') {
                res += sign * num;  // 结算上一段
                num = 0;
                sign = (c == '+') ? 1 : -1;
            }
        }
        return res + sign * num;   // 结算最后一段
    }
}
