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
        int res = 0;
        int limit = Integer.MAX_VALUE / 10;
        while (i < n) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') break;
            int d = c - '0';
            if (res > limit || res == limit && d > 7) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + d;
            i++;
        }
        return sign * res;
    }

    class Solution_DFA {

        public int myAtoi(String s) {
            int state = 0, sign = 1, ans = 0;
            int limit = Integer.MAX_VALUE / 10; // 提前算出除以 10 的阈值
            // 状态转移表 (DFA)
            // 行代表：状态 (0:初始, 1:已遇符号 2:数字, 3:结束)
            // 列代表：字符 (0:空格, 1:正负号    2:数字, 3:其他字符)
            int[][] table = {
                    /* 状态/字符*/   /* 空格(0) */  /* 符号(1) */  /* 数字(2) */  /* 其他(3) */
                    /* 0: start */    {0, 1, 2, 3},
                    /* 1: signed */   {3, 3, 2, 3},
                    /* 2: in_num */   {3, 3, 2, 3},
                    /* 3: end */      {3, 3, 3, 3}};

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int col = getColumn(c);
                state = table[state][col];
                if (state == 2) {
                    int d = c - '0';
                    if (ans > limit || (ans == limit && d > 7)) {
                        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                    ans = ans * 10 + d;
                } else if (state == 1) {
                    sign = c == '+' ? 1 : -1;
                } else if (state == 3) {
                    break;
                }
            }
            return sign * ans;
        }

        // 获取字符对应的列索引
        private int getColumn(char c) {
            if (c == ' ') return 0;
            if (c == '+' || c == '-') return 1;
            if (c >= '0' && c <= '9') return 2;
            return 3;
        }
    }
}
