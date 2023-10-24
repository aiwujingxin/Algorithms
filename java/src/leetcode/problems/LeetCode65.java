package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 14:52
 */
public class LeetCode65 {
    public boolean isNumber(String s) {
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
        //idx不等于-1说明字符串中有e，得分成两部分判断，左侧可以任意数，右侧只能是整数，所以左侧mustInteger设为false，右侧为true
        //否则字符串中没有e，直接调用check函数
        if (idx != -1) {
            ans &= check(chars, 0, idx - 1, false);
            ans &= check(chars, idx + 1, n - 1, true);
        } else {
            ans &= check(chars, 0, n - 1, false);
        }
        return ans;
    }

    //判断是整数还是浮点数
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
