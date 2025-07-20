package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 14:52
 */
public class LeetCode65 {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.isEmpty()) return false;
        int e = s.indexOf('e') != -1 ? s.indexOf('e') : s.indexOf('E');
        if (e != -1) {
            return isValid(s.substring(0, e), false) && isValid(s.substring(e + 1), true);
        }
        return isValid(s, false);
    }

    private boolean isValid(String s, boolean mustInt) {
        if (s.isEmpty()) return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);
        boolean hasDigit = false, hasDot = false;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (c == '.') {
                if (mustInt || hasDot) return false;
                hasDot = true;
            } else {
                return false;
            }
        }
        return hasDigit;
    }
}
