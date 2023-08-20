package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/30 19:12
 */
public class LeetCode439 {

    public String parseTernary(String expression) {
        int count = 0; // 用于找到与最开始的?匹配的:
        for (int i = 1; i < expression.length() - 1; i++) {
            if (expression.charAt(i) == '?') {
                count++;
            }
            if (expression.charAt(i) == ':') {
                count--;
            }
            if (count == 0) {
                char c = expression.charAt(0);
                if (c == 'T') {
                    return parseTernary(expression.substring(2, i));
                } else {
                    return parseTernary(expression.substring(i + 1));
                }
            }
        }
        return expression;
    }
}
