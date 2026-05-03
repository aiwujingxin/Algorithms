package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 13:13
 */
public class LeetCode8 {

    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        while (i < n && s.charAt(i) == ' ') i++;
        if (i == n) return 0;
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = s.charAt(i++) == '-' ? -1 : 1;
        }
        int ans = 0;
        for (; i < n; i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') break;
            int d = c - '0';
            if (ans > (Integer.MAX_VALUE - d) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + d;
        }
        return sign * ans;
    }

    class Solution_DFA {

        public int myAtoi(String s) {
            int state = 0, sign = 1, ans = 0;
            int[][] DFA = {
                    /*空格 符号 数字 其他 */
                    {0, 1, 2, 3}, // init
                    {3, 3, 2, 3}, // sign
                    {3, 3, 2, 3}, // num
                    {3, 3, 3, 3}  // end
            };
            for (char c : s.toCharArray()) {
                state = DFA[state][getInputType(c)];
                if (state == 3) break; // 遇到结束状态直接退出，避免无意义的遍历
                if (state == 1) {
                    sign = c == '+' ? 1 : -1;
                } else if (state == 2) {
                    int d = c - '0';
                    if (ans > (Integer.MAX_VALUE - d) / 10) {
                        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                    ans = ans * 10 + d;
                }
            }
            return sign * ans;
        }

        private int getInputType(char c) {
            if (c == ' ') return 0;
            if (c == '+' || c == '-') return 1;
            if (c >= '0' && c <= '9') return 2;
            return 3;
        }
    }
}
