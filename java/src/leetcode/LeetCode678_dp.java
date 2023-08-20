package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/13 22:46
 */

//https://leetcode.cn/problems/valid-parenthesis-string/solution/gong-shui-san-xie-yi-ti-shuang-jie-dong-801rq/
public class LeetCode678_dp {
    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n + 1][n + 1];
        f[0][0] = true;
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            for (int j = 0; j <= i; j++) {
                if (c == '(') {
                    if (j - 1 >= 0) {
                        f[i][j] = f[i - 1][j - 1];
                    }

                } else if (c == ')') {
                    if (j + 1 <= i) {
                        f[i][j] = f[i - 1][j + 1];
                    }

                } else {
                    f[i][j] = f[i - 1][j];
                    if (j - 1 >= 0) {
                        f[i][j] |= f[i - 1][j - 1];
                    }

                    if (j + 1 <= i) {
                        f[i][j] |= f[i - 1][j + 1];
                    }
                }
            }
        }
        return f[n][0];
    }
}
