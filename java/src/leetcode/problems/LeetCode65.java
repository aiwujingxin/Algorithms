package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 14:52
 */
public class LeetCode65 {

    public boolean isNumber(String s) {
        s = s.trim();
        boolean num = false, dot = false, exp = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (dot || exp) return false;   // 只能有一个点，且不能在 e 后
                dot = true;
            } else if (c == 'e' || c == 'E') {
                if (exp || !num) return false;  // 只能有一个 e，且 e 前必须有数字
                exp = true;
                num = false;                    // 重置 num，确保 e 后必须接数字
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false; // 符号只能在首位或 e 后
            } else {
                return false;                   // 非法字符
            }
        }
        return num;                             // 最终必须包含数字
    }
}
