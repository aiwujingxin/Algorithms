package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/7 14:39
 */
public class LeetCode2232 {

    public String minimizeResult(String expression) {
        int index = expression.indexOf("+");
        int min = Integer.MAX_VALUE;
        String res = expression;
        for (int i = 0; i < index; i++) {
            int a = i == 0 ? 1 : Integer.parseInt(expression.substring(0, i));
            int b = Integer.parseInt(expression.substring(i, index));
            for (int j = index + 2; j <= expression.length(); j++) {
                int c = Integer.parseInt(expression.substring(index + 1, j));
                int d = j == expression.length() ? 1 : Integer.parseInt(expression.substring(j));
                if (a * (b + c) * d < min) {
                    min = a * (b + c) * d;
                    res = (i == 0 ? "" : a) + "(" + b + "+" + c + ")" + (j == expression.length() ? "" : d);
                }
            }
        }
        return res;
    }
}
