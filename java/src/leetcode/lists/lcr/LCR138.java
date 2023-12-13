package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 14:52
 */
public class LCR138 {

    public boolean isNumber(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int idx = -1; //判断e/E在字符串中的索引，用来把字符串分成两部分
        //找到e/E在字符串中的索引，赋值给idx.如果idx不等于-1，说明有两个e，直接返回false
        for (int i = 0; i < n; i++) {
            if (cs[i] == 'e' || cs[i] == 'E') {
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
            ans &= check(cs, 0, idx - 1, false);
            ans &= check(cs, idx + 1, n - 1, true);
        } else {
            ans &= check(cs, 0, n - 1, false);
        }
        return ans;
    }

    //判断是整数还是浮点数
    boolean check(char[] cs, int start, int end, boolean mustInteger) {
        if (start > end) return false;
        if (cs[start] == '+' || cs[start] == '-') start++;
        boolean hasDot = false, hasNum = false;
        for (int i = start; i <= end; i++) {
            if (cs[i] == '.') {
                if (mustInteger || hasDot) return false;
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
