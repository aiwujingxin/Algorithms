package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 12/24/25 22:46
 */
public class LeetCode3216 {

    public String getSmallestString(String s) {
        char[] t = s.toCharArray();
        for (int i = 1; i < t.length; i++) {
            char x = t[i - 1];
            char y = t[i];
            if (x > y && x % 2 == y % 2) {
                t[i - 1] = y;
                t[i] = x;
                break;
            }
        }
        return new String(t);
    }
}
