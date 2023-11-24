package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 14:52
 */
public class LeetCode65 {
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        s = s.trim();
        int n = s.length();
        char[] chars = s.toCharArray();
        //1.判断e/E
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'e' || chars[i] == 'E') {
                if (idx == -1) {
                    idx = i;
                } else {
                    return false;
                }
            }
        }
        boolean ans = true;
        if (idx != -1) {//有e
            //“e”之前的子字符串允许是一个小数，后者只允许是整数。所以左侧mustInteger设为false，右侧为true
            ans &= check(chars, 0, idx - 1, false);
            ans &= check(chars, idx + 1, n - 1, true);
        } else {
            ans &= check(chars, 0, n - 1, false);
        }
        return ans;
    }

    //判断是整数还是浮点数
    //合法的小数的定义是：数字+最多一个小数点。合法的整数的定义是：数字+没有小数点。
    boolean check(char[] cs, int start, int end, boolean mustInteger) {
        if (start > end) {
            return false;
        }
        if (cs[start] == '+' || cs[start] == '-') {
            start++;
        }
        boolean hasDot = false;
        boolean hasNum = false;
        for (int i = start; i <= end; i++) {
            if (cs[i] == '.') {
                if (mustInteger || hasDot) {
                    return false;
                }
                hasDot = true;
            } else if (cs[i] >= '0' && cs[i] <= '9') {
                hasNum = true;
            } else {
                return false;
            }
        }
        return hasNum;
    }
}
